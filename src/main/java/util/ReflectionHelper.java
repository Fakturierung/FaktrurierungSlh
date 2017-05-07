package util;

import org.apache.commons.lang3.reflect.FieldUtils;

/**
 * Reflection Helper using Apache Commons
 * @author ngj
 *
 */
public class ReflectionHelper {

	public static Class<?> getTypeFrom(String field){
		return null;
	}
	
	public static Object readValue(Object source, String field){
		Object theObjectIWanted;
		try {
			theObjectIWanted = FieldUtils.readField(source, field, true);
		} catch (IllegalAccessException e) {
			return "Error";
		}
		return theObjectIWanted;
	}
	
}
