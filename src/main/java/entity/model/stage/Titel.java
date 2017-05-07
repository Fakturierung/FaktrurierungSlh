package entity.model.stage;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Titel
 *
 * @author ngj
 */
@Entity
@Table(name = "tbl_stn_Titel")
public class Titel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titelBeschreibung;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitelBeschreibung() {
        return titelBeschreibung;
    }

    public void setTitelBeschreibung(String titelBeschreibung) {
        this.titelBeschreibung = titelBeschreibung;
    }

}
