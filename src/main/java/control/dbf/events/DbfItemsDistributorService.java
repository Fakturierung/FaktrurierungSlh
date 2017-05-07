package control.dbf.events;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import aop.Duration;
import config.MYSQL;
import control.dbf.distribution.DbfItemsExecutorService;
import control.dbf.distribution.DbfRowDataDistributionMonitor;
import entity.dbf.DbfRowData;
import entity.dbf.DbfRowDataProcessStatusEnum;

/**
 * DbfItems Distributor
 * 
 * @author ngj
 *
 */
@Stateless
public class DbfItemsDistributorService {

	@Inject
	private Logger logger;

	@Inject
	@MYSQL
	private EntityManager em;

	@Inject
	private DbfRowDataDistributionMonitor distributionMonitor;
	@Inject
	private DbfItemsExecutorService dbfItemsExecutorService;

//	@Duration
	public void distribute(@Observes DbfRowDataEvent dbfRowDataEvent) {
		distributionMonitor.setDistributionAvailable(Boolean.FALSE);
		/* retrieve data */
		List<DbfRowData> dbfRowDatas = dbfRowDataEvent.getDbfRowDatas();
		DbfRowDataProcessStatusEnum processStatusEnum = dbfRowDataEvent.getProcessStatus();
		logger.debug("--- DBFRowData EVENT received - CONTENTS [#'{}' DbfRowData-ITEMS, UPDATE from 'INITIAL Status' to '{}' Status] ---",
				new Object[] { dbfRowDatas.size(), processStatusEnum });
		/* distribution */
		for (DbfRowData rowData : dbfRowDatas) {
			rowData.setStatus(processStatusEnum);
			DbfRowData savedDbfRowData = updateStatus(rowData);
			/* map RowData to Target Entities */
			dbfItemsExecutorService.createNeededEntitiesFrom(savedDbfRowData, em);
		}
	}

	// public void test(@Observes DbfRowDataEvent event, final EventMetadata
	// meta){
	// logger.debug("--- EVENT received from '{}' with Data Size '{}' ---",
	// new Object[]{meta, event.getDbfRowDatas().size()});
	// }

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public DbfRowData updateStatus(DbfRowData dbfRowData) {
		DbfRowData saved = em.merge(dbfRowData);
		em.flush();
		return saved;
	}

}
