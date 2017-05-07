package control.dbf.files;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;

import aop.Duration;
import config.MYSQL;
import entity.dbf.DbfFilesMetadata;
import entity.dbf.DbfRowData;

@Singleton
@Startup
public class DbfFilesMetaDataProvider {

	private Map<String, DbfFilesMetadata> dbfFilesConfigMap;
	private Map<String, List<DbfRowData>> dbfFileParserConfigMap;

	@Inject
	private Logger logger;

	@Inject
	@MYSQL
	private EntityManager em;

	@PostConstruct
	public void init() {
		if (null == em) {
			logger.error("Persistence.Unit not available!");
			return;
		}
		this.dbfFilesConfigMap = new HashMap<>();
		this.dbfFileParserConfigMap = new HashMap<>();
		logger.info("--- DbfFilesManagerService.INIT Complete ---");
		loadDbfFilesConfig();
		loadDbfRowDataByTypeId();
	}

	@PreDestroy
	public void destroy() {
		this.dbfFilesConfigMap.clear();
		logger.info("--- DbfFilesManagerService.INIT Shutdown ---");
	}

	public void loadDbfFilesConfig() {
		List<DbfFilesMetadata> resultList = null;
		try {
			resultList = em.createNamedQuery(DbfFilesMetadata.QUERY_DBF_FILEMETADATA_SELECT, DbfFilesMetadata.class)
					.getResultList();
		} catch (Exception exception) {
			logger.error("--- EXCEPTION - Execution of Query '{}' - '{}' ---", new Object[] {
					DbfFilesMetadata.QUERY_DBF_FILEMETADATA_SELECT, exception.getCause().getLocalizedMessage() });
		}
		resultList = (List<DbfFilesMetadata>) CollectionUtils.emptyIfNull(resultList);
		logger.info("--- Query '{}' - Result SIZE '{}' ---",
				new Object[] { DbfFilesMetadata.QUERY_DBF_FILEMETADATA_SELECT, resultList.size() });
		for (DbfFilesMetadata dbfFile : resultList) {
			String dbfFileName = dbfFile.getDbfFileName();
			if (!this.dbfFilesConfigMap.containsKey(dbfFileName)) {
				this.dbfFilesConfigMap.put(dbfFileName, dbfFile);
			}
		}
		logger.info("--- DbfFilesMetadata Settings SUCCESSFULY loaded! - FileNames ['{}'] ---",
				new Object[] { this.dbfFilesConfigMap.keySet() });
	}

	public void loadDbfRowDataByTypeId() {
		List<DbfRowData> resultList = null;
		try {
			resultList = em.createNamedQuery(DbfRowData.QUERY_DBF_ROWDATA_SELECT, DbfRowData.class).getResultList();
		} catch (Exception exception) {
			logger.error("--- EXCEPTION - Execution of Query '{}' - '{}' ---",
					new Object[] { DbfRowData.QUERY_DBF_ROWDATA_SELECT, exception.getCause().getLocalizedMessage() });
			return;
		}
		resultList = (List<DbfRowData>) CollectionUtils.emptyIfNull(resultList);
		logger.info("--- Query '{}' - Result SIZE '{}' ---",
				new Object[] { DbfRowData.QUERY_DBF_ROWDATA_SELECT, resultList.size() });
		for (DbfRowData data : resultList) {
			String typeId = data.getTypeId();
			if (dbfFileParserConfigMap.isEmpty() || !this.dbfFileParserConfigMap.containsKey(typeId)) {
				this.dbfFileParserConfigMap.put(typeId, new ArrayList<>());
			}
			this.dbfFileParserConfigMap.get(typeId).add(data);
		}
	}

	public Map<String, DbfFilesMetadata> getDbfFilesConfigMap() {
		return dbfFilesConfigMap;
	}

	public Map<String, List<DbfRowData>> getDbfFileParserConfigMap() {
		return dbfFileParserConfigMap;
	}

}
