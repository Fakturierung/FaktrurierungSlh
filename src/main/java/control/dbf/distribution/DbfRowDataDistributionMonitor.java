package control.dbf.distribution;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.slf4j.Logger;

import entity.dbf.DbfRowData;

@Singleton
@Startup
public class DbfRowDataDistributionMonitor {

	@Inject
	Logger logger;

	private boolean isDistributionAvailable;
	private Map<Long, DbfRowData> monitorMap;

	@PostConstruct
	public void init() {
		this.isDistributionAvailable = Boolean.TRUE;
		this.monitorMap = new HashMap<>();
		logger.info("--- DBF RowData Distribution MONITOR.INIT complete, STATUS = '{}' ---",
				new Object[] { isDistributionAvailable });
	}

	public boolean isDistributionAvailable() {
		return isDistributionAvailable;
	}

	public void setDistributionAvailable(boolean isDistributionAvailable) {
		this.isDistributionAvailable = isDistributionAvailable;
	}

	public Map<Long, DbfRowData> getMonitorMap() {
		return monitorMap;
	}

	public void setMonitorMap(Map<Long, DbfRowData> monitorMap) {
		this.monitorMap = monitorMap;
	}

}
