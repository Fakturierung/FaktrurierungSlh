package entity.recon;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "dbf_differencetypeid", schema = "fak3")
@XmlRootElement
public class DbfDifferenceType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Enumerated(EnumType.ORDINAL)
	private DifferenceTypeEnum type;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DifferenceTypeEnum getType() {
		return type;
	}

	public void setType(DifferenceTypeEnum type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "DbfDifferenceType [id=" + id + ", type=" + type + "]";
	}

}
