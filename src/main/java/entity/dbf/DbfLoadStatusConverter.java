package entity.dbf;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Attribute Converter
 * @author ngj
 *
 */
@Converter
public class DbfLoadStatusConverter implements AttributeConverter<DbfFileLoadStatusEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(DbfFileLoadStatusEnum attribute) {
        switch(attribute){
            case INITIAL: return 0;
            case PROCESSING: return 1;
            case TERMINATED: return 2;
            case FAILED: return -1;
            case UNDEFINIED:return -2;
        }
        return -2;
    }

    @Override
    public DbfFileLoadStatusEnum convertToEntityAttribute(Integer dbData) {
        switch(dbData){
            case 0: return DbfFileLoadStatusEnum.INITIAL;
            case 1: return DbfFileLoadStatusEnum.PROCESSING;
            case 2: return DbfFileLoadStatusEnum.TERMINATED;
            case -1: return DbfFileLoadStatusEnum.FAILED;
            case -2: return DbfFileLoadStatusEnum.UNDEFINIED;
        }
        return DbfFileLoadStatusEnum.UNDEFINIED;
    }

}
