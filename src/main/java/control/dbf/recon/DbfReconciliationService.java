package control.dbf.recon;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import aop.Duration;
import config.ReconUnit;
import entity.recon.DbfReconcialition;
import entity.recon.DbfTableReconStat;

@Stateless
@Duration
public class DbfReconciliationService {

	@Inject
	Logger logger;

	@Inject
	SqlHelper sqlHelper;
	
	@Inject 
	@ReconUnit EntityManager reconPU;

	public List<DbfTableReconStat> doReconcilation(List<String> entities) {
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		logger.info("---  RECONCILIATION of TABLES ['{}'] starting ---", new Object[] { entities });
		List<DbfTableReconStat> allStatistics = new ArrayList<>();
		for (String table : entities) {
			if (StringUtils.isEmpty(table)) {
				logger.warn("--- invalid Table '{}' given ---", new Object[] { table });
			}
			DbfTableReconStat calculatedStat = processTable(table);			
			allStatistics.add(calculatedStat);
		}
		
		return allStatistics;

	}

	public List<DbfTableReconStat> doReconcilation(DbfReconcialition recon) {
		List<String> entities = buildFrom(recon.getTableName());
		if (CollectionUtils.isEmpty(entities)) {
			return null;
		}
		logger.info("---  RECONCILIATION of TABLES ['{}'] starting ---", new Object[] { entities });
		List<DbfTableReconStat> allStatistics = new ArrayList<>();
		for (String table : entities) {
			if (StringUtils.isEmpty(table)) {
				logger.warn("--- invalid Table '{}' given ---", new Object[] { table });
			}
			DbfTableReconStat calculatedStat = processTable(table);
			calculatedStat.setRecon(String.valueOf(recon.getId()));
			reconPU.merge(calculatedStat);
			allStatistics.add(calculatedStat);
		}
		
		return allStatistics;

	}
	
	
	private DbfTableReconStat processTable(String table) {
		DbfTableReconStat stat = sqlHelper.execute(table, "fak", "fak2", "kundennummer");
		return stat;
	}

	private List<String> buildFrom(String tables){
		if(StringUtils.isEmpty(tables)){
			return null;
		}
		List<String> list = new ArrayList<>();
		final String delimiter = ";";
		StringTokenizer stk = new StringTokenizer(tables, delimiter);
		while(stk.hasMoreTokens()){
			list.add(stk.nextToken());
		}
		return list;
	}
	
}
