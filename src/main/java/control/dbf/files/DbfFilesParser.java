package control.dbf.files;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.jamel.dbf.structure.DbfDataType;
import org.jamel.dbf.structure.DbfField;
import org.jamel.dbf.structure.DbfHeader;
import org.jamel.dbf.structure.DbfRow;
import org.slf4j.Logger;

/**
 * DBF File Content Parser
 * @author ngj
 *
 */
public class DbfFilesParser {

	@Inject
	private Logger logger;

	public Map<String, DbfDataType> parseHeader(String fileName, DbfHeader header) {
		Map<String, DbfDataType> map = new HashMap<>();
		logger.debug("--- PARSING HEADERS of DBF File '{}' starting ---", new Object[] { fileName });
		int fieldsCount = header.getFieldsCount();
		for (int index = 0; index < fieldsCount; index++) {
			DbfField field = header.getField(index);
			DbfDataType dataType = field.getDataType();
			String name = field.getName();
			map.put(name, dataType);
		}
		logger.debug("--- PARSING HEADERS of DBF File '{}' Done - OUTPUT [DBF Header Fields with DbfDataTypes: '{}'] ---", new Object[] { map });
		return map;
	}

	public String[] parseRow(Map<String, DbfDataType> headersInfos, DbfRow row, Charset charset) {
		List<String> values = new ArrayList<>();
		Set<String> fieldNames = headersInfos.keySet();
		Iterator<String> iterator = fieldNames.iterator();
		int count = 0;
		String field = null;
		while (iterator.hasNext()) {
			try {
				field = iterator.next();
				DbfDataType fieldDataType = headersInfos.get(field);
				count++;
				switch (fieldDataType) {
				case CHAR:
					values.add(row.getString(field));
					break;
				case DATE:
					Date date = row.getDate(field);
					values.add(date.toString());
					break;
				case FLOAT:
//					values.add(Float.toString(row.getFloat(field)));
					values.add(Double.toString(row.getBigDecimal(field).doubleValue()));
					break;
				case NUMERIC:
//					values.add(Double.toString(row.getDouble(field)));
					values.add(Long.toString(row.getLong(field)));
					break;
				case LOGICAL:
					values.add(Boolean.toString(row.getBoolean(field)));
					break;
				
				}
			} catch (NullPointerException npe) {
				logger.warn("--- NPE occurs on row '{}' - field '{}' ---", new Object[] { count, field });
			}
		}
		return values.toArray(new String[] {});
	}

}
