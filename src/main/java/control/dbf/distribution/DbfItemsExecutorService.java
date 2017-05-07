package control.dbf.distribution;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import control.dbf.events.MonitorEvent;
import entity.dbf.DbfItem;
import entity.dbf.DbfRowData;
import entity.dbf.DbfRowDataProcessStatusEnum;

/**
 * create and save Entities based on dbfRowData and DbfItems
 * 
 * @author ngj
 *
 */
@Stateless
public class DbfItemsExecutorService {

	@Inject
	private Logger logger;

	@Inject
	private DbfItemsMetaDataProvider dbfItemsMetaDataProvider;

	@Inject
	private Event<MonitorEvent> eventMonitor;

	@Asynchronous
	public void createNeededEntitiesFrom(final DbfRowData dbfRowData, final EntityManager em) {
		Long typeId = Long.valueOf(dbfRowData.getTypeId());
		Map<Class<?>, List<DbfItem>> dbfItemsByClass = dbfItemsMetaDataProvider.filterByTargetClass(typeId);
		Set<Class<?>> targetClasses4RowData = dbfItemsByClass.keySet();
		if (CollectionUtils.isNotEmpty(targetClasses4RowData)) {
			logger.debug("--- TargetClasses '{}' ---", new Object[] { targetClasses4RowData });
			Iterator<Class<?>> iterator = targetClasses4RowData.iterator();
			while (iterator.hasNext()) {
				Class<?> targetClass = iterator.next();
				List<DbfItem> selectedItems4TargetClass = dbfItemsByClass.get(targetClass);
				try {
					Object object = targetClass.newInstance();
					Object topLevelObject = null;
					Object targetSubLevelObject = null;
					Map<String, Object> topLevelClassesMap = new HashMap<>();
					for (DbfItem dbfItem : selectedItems4TargetClass) {
						String targetPropName = dbfItem.getTargetColumn();
						String targetSubPropName = null;
						String targetSubSubPropName = null;
						Object beanProperty = null;
						List<String> subPropNames = null;
						if (targetPropName.indexOf(".") > 0) {
							subPropNames = retrisveSubPropertiesFromString(targetPropName, ".");
							int index = targetPropName.indexOf(".");
							String targetTopLevelPropName = targetPropName.substring(0, index);
							targetSubPropName = targetPropName.substring(index + 1);
							if (targetSubPropName.indexOf(".") > 0) {
								targetSubSubPropName = subPropNames.get(2);
							}
							logger.debug("--- Found SubProperty '{}' ---", new Object[] { targetSubPropName });
							/* create object */
							try {
								Field field = object.getClass().getDeclaredField(targetTopLevelPropName);
								Class<?> targetTopLevelClass = field.getType();
								/* update map */
								if (!topLevelClassesMap.containsKey(targetTopLevelPropName)) {
									topLevelObject = targetTopLevelClass.newInstance();
									topLevelClassesMap.put(targetTopLevelPropName, topLevelObject);
								} else {
									topLevelObject = topLevelClassesMap.get(targetTopLevelPropName);
								}
								if (StringUtils.isNotEmpty(targetSubSubPropName)) {
									Field subField = topLevelObject.getClass().getDeclaredField(subPropNames.get(1));
									Class<?> targetSubLevelClass = subField.getType();
									targetSubLevelObject = targetSubLevelClass.newInstance();
									BeanUtils.setProperty(topLevelObject, subPropNames.get(1), targetSubLevelObject);
								}
							} catch (NoSuchFieldException e) {
								e.printStackTrace();
							} catch (SecurityException e) {
								e.printStackTrace();
							}
							/* topLevelObject already known? */
							Object found = BeanUtils.getProperty(object, targetTopLevelPropName);
							if (null == found) {
								BeanUtils.setProperty(object, targetTopLevelPropName, topLevelObject);
							}
							beanProperty = topLevelObject;
						}
						boolean isSubProperty = (null != beanProperty) ? true : false;
						int position = dbfItem.getPosition();
						String fieldDatatype = dbfItem.getFieldDatatype();
						String targetPropType = dbfItem.getTargetDatatype();
						boolean isPK = dbfItem.isIsPK();
						if (isPK) {
							logger.debug("--- Found PK '{}' ---", new Object[] { targetPropName });
						}
						String propName = getRowDataFieldByPosition("f", position, 0, 100);
						if (StringUtils.isEmpty(propName)) {
							continue;
						}
						String value = BeanUtils.getProperty(dbfRowData, propName);
						Object fieldValue = null;
						/* Source */
						switch (fieldDatatype) {
						case "Double":
							fieldValue = Double.valueOf(value);
							break;
						case "String":
							fieldValue = value;
							break;
						case "Long":
							fieldValue = Long.valueOf(value);
							break;
						case "Boolean":
							fieldValue = Boolean.valueOf(value);
							break;
						}
						/* Target */
						boolean isSubSusProp = (null != subPropNames && subPropNames.size() == 3) ? true : false;
						switch (targetPropType) {
						case "String":
							if (isSubSusProp) {
								BeanUtils.copyProperty(targetSubLevelObject, targetSubSubPropName, fieldValue);
							} else {
								BeanUtils.copyProperty(((isSubProperty) ? topLevelObject : object),
										((isSubProperty) ? targetSubPropName : targetPropName), fieldValue);
							}
							break;
						case "Long":
							if (isSubSusProp) {
								BeanUtils.copyProperty(targetSubLevelObject, targetSubSubPropName,
										((Number) fieldValue).longValue());
							} else {
								BeanUtils.copyProperty(((isSubProperty) ? topLevelObject : object),
										((isSubProperty) ? targetSubPropName : targetPropName),
										((Number) fieldValue).longValue());
							}
							break;
						case "Double":
							if (isSubSusProp) {
								BeanUtils.copyProperty(targetSubLevelObject, targetSubSubPropName,
										((Number) fieldValue).doubleValue());
							} else {
								BeanUtils.copyProperty(((isSubProperty) ? topLevelObject : object),
										((isSubProperty) ? targetSubPropName : targetPropName),
										((Number) fieldValue).doubleValue());
							}
							break;
						case "Boolean":
							if (isSubSusProp) {
								BeanUtils.copyProperty(targetSubLevelObject, targetSubSubPropName,
										((Boolean) fieldValue).booleanValue());
							} else {
								BeanUtils.copyProperty(((isSubProperty) ? topLevelObject : object),
										((isSubProperty) ? targetSubPropName : targetPropName),
										((Boolean) fieldValue).booleanValue());
							}
							break;
						}
					}
					/* merge all classes from Map */
					 Set<String> classes2Merge = topLevelClassesMap.keySet();
					/* merge Object */
					em.persist(object);
					logger.info("--- Distribution DONE - Object '{}' saved to TargetTables ['{}'] ---",
							new Object[] { object, classes2Merge });
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException | NoSuchMethodException e) {
					e.printStackTrace();
				}
				logger.info("ENDE - UPDATE MONITOR with DBF ROWDATA ID");
				MonitorEvent monitorEvent = new MonitorEvent(dbfRowData, DbfRowDataProcessStatusEnum.TERMINATED);
				eventMonitor.fire(monitorEvent);
			}
		}
	}

	private String getRowDataFieldByPosition(String prefix, int position, int min, int max) {
		if (position <= min || position > max) {
			return null;
		}
		StringBuilder propName = new StringBuilder(prefix.toLowerCase());
		if (position < 10) {
			propName.append("0");
		}
		propName.append(position);
		return propName.toString();
	}

	private List<String> retrisveSubPropertiesFromString(String propertyNameAsObject, String delimiter) {
		List<String> tokens = new ArrayList<>();
		if (StringUtils.isNotEmpty(propertyNameAsObject)) {
			StringTokenizer stk = new StringTokenizer(propertyNameAsObject, delimiter);
			while (stk.hasMoreTokens()) {
				String subPropertyName = stk.nextToken();
				tokens.add(subPropertyName);
			}
		}
		return tokens;
	}

}
