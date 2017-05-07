package entity.recon;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "dbf_recon", schema = "fak3")
@XmlRootElement
public class DbfReconcialition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date cdate;
	@Column(name = "tableName")
	private String tableName;

	@Column(name = "typ0")
	private long differencesTyp0;
	@Column(name = "typ1")
	private long differencesTyp1;
	@Column(name = "typ2")
	private long differencesTyp2;
	@Column(name = "source")
	private long typeid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public long getDifferencesTyp0() {
		return differencesTyp0;
	}

	public void setDifferencesTyp0(long differencesTyp0) {
		this.differencesTyp0 = differencesTyp0;
	}

	public long getDifferencesTyp1() {
		return differencesTyp1;
	}

	public void setDifferencesTyp1(long differencesTyp1) {
		this.differencesTyp1 = differencesTyp1;
	}

	public long getDifferencesTyp2() {
		return differencesTyp2;
	}

	public void setDifferencesTyp2(long differencesTyp2) {
		this.differencesTyp2 = differencesTyp2;
	}

	public long getTypeid() {
		return typeid;
	}

	public void setTypeid(long typeid) {
		this.typeid = typeid;
	}

	@Override
	public String toString() {
		return "DbfReconcialition [id=" + id + ", cdate=" + cdate + ", table=" + tableName + ", differencesTyp0="
				+ differencesTyp0 + ", differencesTyp1=" + differencesTyp1 + ", differencesTyp2=" + differencesTyp2
				+ ", typeid=" + typeid + "]";
	}

}
