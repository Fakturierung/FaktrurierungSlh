package entity.model.stage;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ngj
 */
@Entity
@Table(name = "tbl_stn_plz")
public class Postleitzahl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long plz_nr;
	private String land;
	private String zone;
	private String ortsBezeichnung;
	private double inselZuschlag;
	private double cityZuschlag;

	@OneToMany(mappedBy = "plz")
	// @JoinColumn(name = "PLZ_NR")
	private List<PostleitzahlOrtsteil> postleitzahlOrtsteile;

	public long getPlz_nr() {
		return plz_nr;
	}

	public void setPlz_nr(long plz_nr) {
		this.plz_nr = plz_nr;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public List<PostleitzahlOrtsteil> getPostleitzahlOrtsteile() {
		return postleitzahlOrtsteile;
	}

	public void setPostleitzahlOrtsteile(List<PostleitzahlOrtsteil> postleitzahlOrtsteile) {
		this.postleitzahlOrtsteile = postleitzahlOrtsteile;
	}

	public String getOrtsBezeichnung() {
		return ortsBezeichnung;
	}

	public void setOrtsBezeichnung(String ortsBezeichnung) {
		this.ortsBezeichnung = ortsBezeichnung;
	}

	public double getInselZuschlag() {
		return inselZuschlag;
	}

	public void setInselZuschlag(double inselZuschlag) {
		this.inselZuschlag = inselZuschlag;
	}

	public double getCityZuschlag() {
		return cityZuschlag;
	}

	public void setCityZuschlag(double cityZuschlag) {
		this.cityZuschlag = cityZuschlag;
	}

}
