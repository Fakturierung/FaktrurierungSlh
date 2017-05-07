package entity.model.stage;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ngj
 */
@Entity
@Table(name = "tbl_cu_volFaktor")
public class VolFaktor implements Serializable {

	private static final long serialVersionUID = 7189545407919536731L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String beschreibung;
	@Column(name = "volfaktor")
	private double faktor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public double getFaktor() {
		return faktor;
	}

	public void setFaktor(double faktor) {
		this.faktor = faktor;
	}

	@Override
	public String toString() {
		return "VolFaktor [id=" + id + ", beschreibung=" + beschreibung + ", faktor=" + faktor + "]";
	}

}
