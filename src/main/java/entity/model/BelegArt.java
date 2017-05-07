package entity.model;

/**
 *
 * @author ngj
 */
public enum BelegArt {

    RECHNUNG("Rechnung"), GUTSCHRIFT("Gutschrift"), STORNO("Storno");

    private final String value;

    private BelegArt(String s) {
        this.value = s;
    }

    public String getValue() {
        return value;
    }

}
