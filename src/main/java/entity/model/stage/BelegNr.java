package entity.model.stage;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entity.model.BelegArt;

/**
 *
 * @author ngj
 */
@Entity
@Table(name = "TBL_BELEGNR")
public class BelegNr implements Serializable {

	private static final long serialVersionUID = 1122627596506238804L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "JAHR")
	@Temporal(TemporalType.DATE)
	private Date Buchungsjahr;
	private BelegArt belegart;
	@Column(name = "NUMMER")
	private long nummerBelegKreis;

	@Column(name = "LETZTE")
	private long letzteBelegNr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBuchungsjahr() {
		return Buchungsjahr;
	}

	public void setBuchungsjahr(Date Buchungsjahr) {
		this.Buchungsjahr = Buchungsjahr;
	}

	public BelegArt getBelegart() {
		return belegart;
	}

	public void setBelegart(BelegArt belegart) {
		this.belegart = belegart;
	}

	public long getNummerBelegKreis() {
		return nummerBelegKreis;
	}

	public void setNummerBelegKreis(long nummerBelegKreis) {
		this.nummerBelegKreis = nummerBelegKreis;
	}

	public long getLetzteBelegNr() {
		return letzteBelegNr;
	}

	public void setLetzteBelegNr(long letzteBelegNr) {
		this.letzteBelegNr = letzteBelegNr;
	}

}
