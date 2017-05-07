package control.dbf.events;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import config.MYSQL;
import entity.dbf.DbfRowData;
import entity.dbf.DbfRowDataProcessStatusEnum;

@Stateless
public class DbfRowDataProcessingUpdater {

	@Inject 
	private Logger logger;
	
	@Inject
	@MYSQL 
	private EntityManager em;
	
//	@Inject
//	private DbfRowDataDistributionMonitor monitor;
	
	public void update(@Observes final MonitorEvent monitorEvent) {
		logger.debug("--- Monitor EVENT received ---");
		DbfRowData data = monitorEvent.getData();
		long id = data.getId();
		DbfRowDataProcessStatusEnum status2Update = monitorEvent.getStatus();
		DbfRowData found = em.find(DbfRowData.class, id);
		found.setStatus(status2Update);
		em.merge(found);
//		monitor.getMonitorMap().get(data.getInternalId()).setStatus(status);		
	}

}
