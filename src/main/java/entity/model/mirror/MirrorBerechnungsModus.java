package entity.model.mirror;

import java.io.Serializable;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import entity.model.BerechnungsArt;
import entity.model.BerechnungsArtConverter;

/**
 *
 * @author ngj
 */
@Entity
@Table(name = "tbl_pr_berechnungsmodus", schema = "fak2")
public class MirrorBerechnungsModus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Convert(converter = BerechnungsArtConverter.class)
    private BerechnungsArt berechnunsart;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BerechnungsArt getBerechnunsart() {
        return berechnunsart;
    }

    public void setBerechnunsart(BerechnungsArt berechnunsart) {
        this.berechnunsart = berechnunsart;
    }

    @Override
    public String toString() {
        return "BerechnungsModus{" + "id=" + id + ", berechnunsart=" + berechnunsart + '}';
    }

}
