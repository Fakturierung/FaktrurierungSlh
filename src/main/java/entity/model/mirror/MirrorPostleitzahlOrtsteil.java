package entity.model.mirror;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ngj
 */
@Entity
@Table(name = "tbl_stn_plz_ortsteil", schema = "fak2")
public class MirrorPostleitzahlOrtsteil implements Serializable {

	private static final long serialVersionUID = -1139693675736910224L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String land;
    @ManyToOne
    private MirrorPostleitzahl plz;
    private String ortsBezeichnung;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public MirrorPostleitzahl getPlz() {
        return plz;
    }

    public void setPlz(MirrorPostleitzahl plz) {
        this.plz = plz;
    }

    public String getOrtsBezeichnung() {
        return ortsBezeichnung;
    }

    public void setOrtsBezeichnung(String ortsBezeichnung) {
        this.ortsBezeichnung = ortsBezeichnung;
    }

    @Override
    public String toString() {
        return "PostleitzahlOrtsteil{" + "id=" + id + ", land=" + land + ", plz=" + plz + ", ortsBezeichnung=" + ortsBezeichnung + '}';
    }

}
