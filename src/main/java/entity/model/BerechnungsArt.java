package entity.model;

/**
 *
 * @author ngj
 */
public enum BerechnungsArt {

    TAEGLICH("taeglich"),
    WOECHENTLICH("woechentlich"),
    DEKADE("dekade"),
    MONATLICH("monatlich"),
    ZUM_15("zum 15."),
    ZUM_10("zum 10."),
    ZUM_20("zum 20."),
    ZUM_30("zum 30."),
    ULTIMO("ultimo");

    private final String value;

    private BerechnungsArt(String str) {
        this.value = str;
    }

    public String getValue() {
        return value;
    }

}
