package control.dbf.recon;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;

import config.MYSQL;
import entity.recon.DbfTableReconStat;

@Stateless
public class SqlHelper {

	@Inject
	Logger logger;

	@Inject
	@MYSQL
	EntityManager em;

	private Map<String, List<String>> columnsMap;

	@PostConstruct
	public void init() {
		this.columnsMap = new HashMap<>();
		List<String> stammdatenColumns = Arrays.asList("zahlungskondition_id", "vol_faktor_id", "sonderPL_id",
				"nachnahme_id", "dieselfloater_id", "dieselfloater_id", "berechnungsModus_id",
				"abweichender_Frachtzahler_id", "ustid", "strasse", "plz", "ort", "land", "name2", "kundenname",
				"formularCode", "debitornummer", "basisPL");
		this.columnsMap.put("tbl_cu_stammdaten", stammdatenColumns);

	}

//	public DbfTableReconStat _execute(String table, String schema1, String schema2, String pk) {
//		String sqlTyp0 = "select count(*) from fak." + table + " s left join fak2." + table + " t " + "on s." + pk
//				+ " = t." + pk + " and t." + pk + " is null";
//		String sqlTyp1 = "select count(*) from fak." + table + " s right join fak2." + table + " t " + "on s." + pk
//				+ " = t." + pk + " and s." + pk + " is null";
//		logger.info("--- SQL TYP0 ['{}'], SQL TYP1 ['{}'], SQL TYP2 ['{}'] ---",
//				new Object[] { sqlTyp0, sqlTyp1, null });
//		Long typ0 = ((BigInteger) em.createNativeQuery(sqlTyp0).getSingleResult()).longValue();
//		Long typ1 = ((BigInteger) em.createNativeQuery(sqlTyp1).getSingleResult()).longValue();
//
//		DbfTableReconStat stat = new DbfTableReconStat();
//		stat.setCountMissingInTarget(typ0);
//		stat.setCountMissingInSource(typ1);
//		stat.setCountInBoth(0L);
//		stat.setTableName(table);
//
//		return stat;
//	}

	public DbfTableReconStat execute(String table, String schema1, String schema2, String pk) {
		String sqlTyp0 = "select count(*) from " + schema1 + "." + table + " s " + "where s." + pk
				+ " not in (select t." + pk + " from " + schema2 + "." + table + " t where s." + pk + " = t." + pk
				+ ")";
		String sqlTyp1 = 
				"select count(*) from " + schema2 + "." + table + " t " + 
						"where t." + pk + " not in (select s." + pk + " from " + schema1 + "." + table + " s where s." + pk + " = t." + pk
				+ ")";
		String sqlTyp2 = "select count(*) from " + schema1 + "." + table + " s, " + schema2 + "." + table + " t "
				+ "where s." + pk + " = t. " + pk;
		List<String> columns = this.columnsMap.get(table);
		if (CollectionUtils.isNotEmpty(columns)) {
//			StringBuilder sb = new StringBuilder(" and (");
			StringBuilder sb = new StringBuilder(SqlOperators.AND);
			sb.append("(");
			for (int i = 0; i < columns.size(); i++) {
				String column = columns.get(i);
//				sb.append("s.").append(column).append(" != ").append("t.").append(column);
				sb.append("s.").append(column).append(SqlOperators.NEG).append("t.").append(column);
				if (i < columns.size() - 1) {
//					sb.append(" or ");
					sb.append(SqlOperators.OR);
				}
			}
			sb.append(")");
			sqlTyp2 = sqlTyp2 + sb.toString();
		}

		logger.info("--- SQL TYP0 ['{}'] ---\n,--- SQL TYP1 ['{}'] ---\n,--- SQL TYP2 ['{}'] ---",
				new Object[] { sqlTyp0, sqlTyp1, sqlTyp2 });

		Long typ0 = ((BigInteger) em.createNativeQuery(sqlTyp0).getSingleResult()).longValue();
		Long typ1 = ((BigInteger) em.createNativeQuery(sqlTyp1).getSingleResult()).longValue();
		Long typ2 = ((BigInteger) em.createNativeQuery(sqlTyp2).getSingleResult()).longValue();

		DbfTableReconStat stat = new DbfTableReconStat();
		stat.setCountMissingInTarget(typ0);
		stat.setCountMissingInSource(typ1);
		stat.setCountInBoth(typ2);
		stat.setTableName(table);

		return stat;
	}
	
	public void insertDifferences(String schema1, String schema2, String table, String pk, long reconId){
		
		String sqlTyp0 = "select * from " + schema1 + "." + table + " s " + "where s." + pk
				+ " not in (select t." + pk + " from " + schema2 + "." + table + " t where s." + pk + " = t." + pk
				+ ")";
		String sqlTyp1 = 
				"select * from " + schema2 + "." + table + " t " + 
						"where t." + pk + " not in (select s." + pk + " from " + schema1 + "." + table + " s where s." + pk + " = t." + pk
				+ ")";
		String sqlTyp2 = "select * from " + schema1 + "." + table + " s, " + schema2 + "." + table + " t "
				+ "where s." + pk + " = t. " + pk;
		List<String> columns = this.columnsMap.get(table);
		if (CollectionUtils.isNotEmpty(columns)) {
			StringBuilder sb = new StringBuilder(SqlOperators.AND);
			sb.append("(");
			for (int i = 0; i < columns.size(); i++) {
				String column = columns.get(i);
				sb.append("s.").append(column).append(SqlOperators.NEG).append("t.").append(column);
				if (i < columns.size() - 1) {
					sb.append(SqlOperators.OR);
				}
			}
			sb.append(")");
			sqlTyp2 = sqlTyp2 + sb.toString();
		}
		List<?> typ0 = em.createNativeQuery(sqlTyp0).getResultList();
		List<?> typ1 = em.createNativeQuery(sqlTyp1).getResultList();
		List<?> typ2 = em.createNativeQuery(sqlTyp2).getResultList();

	}

}
