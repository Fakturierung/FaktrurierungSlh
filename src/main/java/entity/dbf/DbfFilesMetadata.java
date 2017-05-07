package entity.dbf;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "dbf_filesmetadata")
@NamedQueries({
		@NamedQuery(name = DbfFilesMetadata.QUERY_DBF_FILEMETADATA_SELECT, query = "select md from DbfFilesMetadata md") })
public class DbfFilesMetadata {

	public static final String QUERY_DBF_FILEMETADATA_SELECT = "DbfFilesMetdata.SelectAll";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "filename")
	private String dbfFileName;

	@Column(name = "typeid")
	private long dbfTypeId;

	@Column(name = "location")
	private String dbfFilePath;

	@Column(name = "cdts")
	@Temporal(TemporalType.TIMESTAMP)
	private Date cDate;

	@Column(name = "lmts")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lDate;

	@Column(name = "status")
	// @Convert(converter = DbfLoadStatusConverter.class)
	@Enumerated(EnumType.ORDINAL)
	private DbfFileLoadStatusEnum status;

	@Column(name = "automatic")
	private boolean isAutomatic;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDbfFileName() {
		return dbfFileName;
	}

	public void setDbfFileName(String dbfFileName) {
		this.dbfFileName = dbfFileName;
	}

	public long getDbfTypeId() {
		return dbfTypeId;
	}

	public void setDbfTypeId(long dbfTypeId) {
		this.dbfTypeId = dbfTypeId;
	}

	public String getDbfFilePath() {
		return dbfFilePath;
	}

	public void setDbfFilePath(String dbfFilePath) {
		this.dbfFilePath = dbfFilePath;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public Date getlDate() {
		return lDate;
	}

	public void setlDate(Date lDate) {
		this.lDate = lDate;
	}

	public DbfFileLoadStatusEnum getStatus() {
		return status;
	}

	public void setStatus(DbfFileLoadStatusEnum status) {
		this.status = status;
	}

	public boolean isAutomatic() {
		return isAutomatic;
	}

	public void setAutomatic(boolean isAutomatic) {
		this.isAutomatic = isAutomatic;
	}

	@Override
	public String toString() {
		return "DbfFilesMetadata [id=" + id + ", dbfFileName=" + dbfFileName + ", dbfTypeId=" + dbfTypeId
				+ ", dbfFilePath=" + dbfFilePath + ", cDate=" + cDate + ", lDate=" + lDate + ", status=" + status
				+ ", isAutomatic=" + isAutomatic + "]";
	}

}
