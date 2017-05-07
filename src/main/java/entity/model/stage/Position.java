package entity.model.stage;

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
@Table(name = "tbl_Position")
public class Position implements Serializable {

	private static final long serialVersionUID = -246102604371814385L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private Titel titel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Titel getTitel() {
		return titel;
	}

	public void setTitel(Titel titel) {
		this.titel = titel;
	}

}
