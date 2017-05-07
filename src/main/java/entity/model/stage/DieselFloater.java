package entity.model.stage;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ngj
 */
@Entity
@Table(name = "tbl_pr_zu_dieselFloater")
@NamedQueries({
		@NamedQuery(name = DieselFloater.DIESELFLOATER_FIND_BY_IDX, query = "select df from DieselFloater df where df.d_idx = :idx") })
public class DieselFloater implements Serializable {

	private static final long serialVersionUID = 4106476294771316794L;

	public static final String DIESELFLOATER_FIND_BY_IDX = "DieselFloater.findByIdx";

	@Id
	private long id;
	private String d_idx;
	@Temporal(TemporalType.DATE)
	private Date datum_vom;
	@Temporal(TemporalType.DATE)
	private Date datum_bis;
	private double zuschlag;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getD_idx() {
		return d_idx;
	}

	public void setD_idx(String d_idx) {
		this.d_idx = d_idx;
	}

	public Date getDatum_vom() {
		return datum_vom;
	}

	public void setDatum_vom(Date datum_vom) {
		this.datum_vom = datum_vom;
	}

	public Date getDatum_bis() {
		return datum_bis;
	}

	public void setDatum_bis(Date datum_bis) {
		this.datum_bis = datum_bis;
	}

	public double getZuschlag() {
		return zuschlag;
	}

	public void setZuschlag(double zuschlag) {
		this.zuschlag = zuschlag;
	}

}
