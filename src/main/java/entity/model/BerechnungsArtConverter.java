package entity.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author ngj
 */
@Converter
public class BerechnungsArtConverter implements AttributeConverter<BerechnungsArt, String> {

    @Override
    public String convertToDatabaseColumn(BerechnungsArt attribute) {
        return attribute.getValue();
    }

    @Override
    public BerechnungsArt convertToEntityAttribute(String dbData) {
        if(StringUtils.isNotEmpty(dbData)){
            switch(dbData){
                case "täglich": return BerechnungsArt.TAEGLICH;
                case "wöchentlich": return BerechnungsArt.WOECHENTLICH;
                case "dekade": return BerechnungsArt.DEKADE;
                case "monatlich": return BerechnungsArt.MONATLICH;
                case "zum 10.": return BerechnungsArt.ZUM_10;
                case "zum 15.": return BerechnungsArt.ZUM_15;
                case "zum 20.": return BerechnungsArt.ZUM_20;
                case "zum 30.": return BerechnungsArt.ZUM_30;
            }
        }
        return null;
    }

}
