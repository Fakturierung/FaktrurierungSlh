package entity.recon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "dbf_difference", schema = "fak3")
@XmlRootElement
public class DbfDifference {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long reconid;
	private String tableName;

	@OneToOne
	private DbfDifferenceType type;

	private String stagePK;
	private String targetPK;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getReconid() {
		return reconid;
	}

	public void setReconid(long reconid) {
		this.reconid = reconid;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getStagePK() {
		return stagePK;
	}

	public void setStagePK(String stagePK) {
		this.stagePK = stagePK;
	}

	public String getTargetPK() {
		return targetPK;
	}

	public void setTargetPK(String targetPK) {
		this.targetPK = targetPK;
	}

	public DbfDifferenceType getType() {
		return type;
	}

	public void setType(DbfDifferenceType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "DbfDifference [id=" + id + ", reconid=" + reconid + ", tableName=" + tableName + ", type=" + type + ", stagePK="
				+ stagePK + ", targetPK=" + targetPK + "]";
	}

}
