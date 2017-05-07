package control.dbf;

import java.lang.reflect.InvocationTargetException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import config.MYSQL;
import entity.dbf.DbfFilesMetadata;
import entity.dbf.DbfRowData;
import entity.dbf.DbfRowDataProcessStatusEnum;

@Stateless
public class DbfRowDataService {

	@Inject
	private Logger logger;

	@Inject
	@MYSQL
	private EntityManager em;

	public long saveRowData(DbfFilesMetadata metadata, String[] values) {
		if (null == em) {
			return -1L;
		}
		String fileName = metadata.getDbfFileName();
		String typeId = Long.toString(metadata.getDbfTypeId());
		/* create DbfRowData Item */
		DbfRowData dbfRowData = buildFrom(fileName, typeId, values);
		if (null != dbfRowData) {
			DbfRowData savedRowData = em.merge(dbfRowData);
			if (savedRowData.getId() > 0L) {
				logger.debug("--- Dbf RowData '{}' successfuly saved to DB ---", new Object[] { savedRowData.toString() });
			}
			return savedRowData.getId();
		}
		return 0L;
	}

	private DbfRowData buildFrom(String fileName, String typeId, String[] values) {
		DbfRowData dbfRowData = new DbfRowData();
		dbfRowData.setSource(fileName);
		dbfRowData.setTypeId(typeId);
		dbfRowData.setStatus(DbfRowDataProcessStatusEnum.INITIAL);
		/* fXXX values */
		for (int i = 0; i < values.length; i++) {
			String value = values[i];
			int j = i + 1;
			String position = (j < 10) ? "0" + j : "" + j;
			String targetProperty = "f" + position;
			try {
				BeanUtils.setProperty(dbfRowData, targetProperty, value);
			} catch (IllegalAccessException | InvocationTargetException ex) {
				logger.error("--- REFLECTION Exception using BeanUtils - Property '{}' with VALUE '{}' ---",
						new Object[] { targetProperty, value });
				return null;
			}
		}
		logger.debug("--- DbfRowData ITEMs created - VALUES ['{}'] ---", new Object[] { dbfRowData.toString() });
		return dbfRowData;
	}

}
