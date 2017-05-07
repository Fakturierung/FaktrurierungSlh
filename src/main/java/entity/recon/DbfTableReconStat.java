package entity.recon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "dbf_reconstat", schema = "fak3")
@XmlRootElement
public class DbfTableReconStat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String recon;
	private String tableName;
	private long countMissingInTarget;
	private long countMissingInSource;
	private long countInBoth;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRecon() {
		return recon;
	}

	public void setRecon(String recon) {
		this.recon = recon;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public long getCountMissingInTarget() {
		return countMissingInTarget;
	}

	public void setCountMissingInTarget(long countMissingInTarget) {
		this.countMissingInTarget = countMissingInTarget;
	}

	public long getCountMissingInSource() {
		return countMissingInSource;
	}

	public void setCountMissingInSource(long countMissingInSource) {
		this.countMissingInSource = countMissingInSource;
	}

	public long getCountInBoth() {
		return countInBoth;
	}

	public void setCountInBoth(long countInBoth) {
		this.countInBoth = countInBoth;
	}

	@Override
	public String toString() {
		return "DbfTableReconStat [id=" + id + ", recon=" + recon + ", tableName=" + tableName + ", countMissingInTarget="
				+ countMissingInTarget + ", countMissingInSource=" + countMissingInSource + ", countInBoth="
				+ countInBoth + "]";
	}

}
