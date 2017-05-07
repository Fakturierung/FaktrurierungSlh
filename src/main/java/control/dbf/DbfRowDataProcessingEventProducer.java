package control.dbf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;

import config.MYSQL;
import control.dbf.distribution.DbfRowDataDistributionMonitor;
import control.dbf.events.DbfRowDataEvent;
import entity.dbf.DbfRowData;
import entity.dbf.DbfRowDataProcessStatusEnum;

@Stateless
public class DbfRowDataProcessingEventProducer {

	@Inject
	private Logger logger;

	@Inject
	@MYSQL
	private EntityManager em;

	@Inject
	private Event<DbfRowDataEvent> event;

	@Inject
	private DbfRowDataDistributionMonitor distributionMonitor;

	private List<DbfRowData> rowDatas;

	@PostConstruct
	public void init() {
		this.rowDatas = new ArrayList<>();
	}

	@Schedules({ 
		@Schedule(hour = "*", minute = "*/30", persistent = false) 
	})
	public void startDdbfRowDataProcessing() {
		if (distributionMonitor.isDistributionAvailable()) {
			loadInitialRowData();
		}
	}

	public void loadInitialRowData() {
		this.rowDatas = em.createNamedQuery(DbfRowData.QUERY_DBF_ROWDATA_SELECT_BY_STATUS, DbfRowData.class)
				.setParameter("status", DbfRowDataProcessStatusEnum.INITIAL).getResultList();
		if (CollectionUtils.isNotEmpty(rowDatas)) {
			logger.info("--- #'{}' DbfRowData ITEMS with STATUS '{}' found for distribution ---",
					new Object[] { rowDatas.size(), DbfRowDataProcessStatusEnum.INITIAL });
			/* Process */
			DbfRowDataEvent dbfRowDataEvent = new DbfRowDataEvent(rowDatas, DbfRowDataProcessStatusEnum.PROCESSING);
			event.fire(dbfRowDataEvent);
			logger.info("--- Data EVENT '{}' fired ---", new Object[] { dbfRowDataEvent });
		} else {
			logger.info("--- No DbfRowData Items with STATUS '{}' found ---",
					new Object[] { DbfRowDataProcessStatusEnum.INITIAL });
		}
	}

	public List<DbfRowData> getRowDatas() {
		return rowDatas;
	}

	public void setRowDatas(List<DbfRowData> rowDatas) {
		this.rowDatas = rowDatas;
	}

}
