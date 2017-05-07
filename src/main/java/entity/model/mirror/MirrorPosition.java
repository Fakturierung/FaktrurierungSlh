package entity.model.mirror;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ngj
 */
@Entity
@Table(name = "tbl_Position", schema = "fak2")
public class MirrorPosition implements Serializable {

	private static final long serialVersionUID = -246102604371814385L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private MirrorTitel titel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MirrorTitel getTitel() {
		return titel;
	}

	public void setTitel(MirrorTitel titel) {
		this.titel = titel;
	}

}
