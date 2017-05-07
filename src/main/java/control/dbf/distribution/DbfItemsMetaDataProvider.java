package control.dbf.distribution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import aop.Duration;
import config.MYSQL;
import entity.dbf.DbfItem;

/**
 * DbfItems Configuration
 * 
 * @author ngj
 *
 */
@Singleton
@Startup
public class DbfItemsMetaDataProvider {

	@Inject
	private Logger logger;

	@Inject
	@MYSQL
	private EntityManager em;
	
	@Inject
	private DbfItemsEntityBuilder dbfItemsEntityBuilder;

	private Map<Long, List<DbfItem>> dbfItemsMap;

	@PostConstruct
	public void init() {
		this.dbfItemsMap = loadDbfItems();
		logger.info("DbfItemsConfigurator.INIT complete");
	}

	private Map<Long, List<DbfItem>> loadDbfItems() {
		if (null == em) {
			logger.error("EntityManager not available!");
			return null;
		}
		/* select */
		Map<Long, List<DbfItem>> data = new HashMap<>();
		List<DbfItem> dbfItems = em.createNamedQuery(DbfItem.QUERY_DBFITEM_SELECT, DbfItem.class).getResultList();
		for (DbfItem dbfItem : dbfItems) {
			Long dbfTypeId = dbfItem.getDbfTypeId();
			if (!data.containsKey(dbfTypeId)) {
				data.put(dbfTypeId, new ArrayList<DbfItem>());
			}
			data.get(dbfTypeId).add(dbfItem);
		}
		return data;
	}

	public List<DbfItem> loadDbfItemsByTypeId(long typeId) {
		List<DbfItem> dbfItems = em.createNamedQuery(DbfItem.QUERY_DBFITEM_SELECT_BY_TYPEID, DbfItem.class)
				.setParameter("typeId", typeId).getResultList();
		return dbfItems;
	}

	public Map<Long, List<DbfItem>> getDbfItemsMap() {
		return dbfItemsMap;
	}

	public Map<Class<?>, List<DbfItem>> filterByTargetClass(Long typeId) {
		Map<Class<?>, List<DbfItem>> dbfItemsByTargetClass = new HashMap<>();
		List<DbfItem> items = dbfItemsMap.get(typeId);
		if(CollectionUtils.isNotEmpty(items)){
			for(DbfItem item : items){
				String targetType = item.getTargetTable();
				if(StringUtils.isNotEmpty(targetType)){
					Class<?> targetClass = dbfItemsEntityBuilder.getString2Classes().get(targetType);
					if(null != targetClass){
						if(!dbfItemsByTargetClass.containsKey(targetClass)){
							dbfItemsByTargetClass.put(targetClass, new ArrayList<>());
						}
						dbfItemsByTargetClass.get(targetClass).add(item);
					}
				}
			}
		}
		return dbfItemsByTargetClass;
	}

}
