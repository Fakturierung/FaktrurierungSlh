package entity.dbf;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DbfRowDataProcessStatusConverter implements AttributeConverter<DbfRowDataProcessStatusEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(DbfRowDataProcessStatusEnum attribute) {
		switch (attribute) {
		case INITIAL:
			return 0;
		case PROCESSING:
			return 1;
		case TERMINATED:
			return 2;
		case ERROR:
			return -1;
		}
		return -2;
	}

	@Override
	public DbfRowDataProcessStatusEnum convertToEntityAttribute(Integer dbData) {
		switch (dbData) {
		case 0:
			return DbfRowDataProcessStatusEnum.INITIAL;
		case 1:
			return DbfRowDataProcessStatusEnum.PROCESSING;
		case 2:
			return DbfRowDataProcessStatusEnum.TERMINATED;
		case -1:
			return DbfRowDataProcessStatusEnum.ERROR;
		}
		return DbfRowDataProcessStatusEnum.ERROR;
	}
}
