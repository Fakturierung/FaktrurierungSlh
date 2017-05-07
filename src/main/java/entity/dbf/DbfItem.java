package entity.dbf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * DbfItem Entity
 * <p>
 * Configuration of DbfItems with typeId and target Entity informations
 * 
 * @author ngj
 *
 */
@Entity
@Table(name = "dbf_item")
@NamedQueries({
		@NamedQuery(name = DbfItem.QUERY_DBFITEM_SELECT, query = "select item from DbfItem item order by item.dbfTypeId"),
		@NamedQuery(name = DbfItem.QUERY_DBFITEM_SELECT_BY_TYPEID, query = "select item from DbfItem item where item.dbfTypeId = :typeId") })
public class DbfItem {

	public static final String QUERY_DBFITEM_SELECT = "DbfItem.selectAll";
	public static final String QUERY_DBFITEM_SELECT_BY_TYPEID = "DbfItem.selectByTypeId";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private long dbfTypeId;
	private String fieldName;
	private String fieldDatatype;
	@Column(name = "cPosition")
	private int position;
	private String targetTable;
	private String targetColumn;
	private String targetDatatype;
	private boolean isPK;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDbfTypeId() {
		return dbfTypeId;
	}

	public void setDbfTypeId(long dbfTypeId) {
		this.dbfTypeId = dbfTypeId;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldDatatype() {
		return fieldDatatype;
	}

	public void setFieldDatatype(String fieldDatatype) {
		this.fieldDatatype = fieldDatatype;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getTargetTable() {
		return targetTable;
	}

	public void setTargetTable(String targetTable) {
		this.targetTable = targetTable;
	}

	public String getTargetColumn() {
		return targetColumn;
	}

	public void setTargetColumn(String targetColumn) {
		this.targetColumn = targetColumn;
	}

	public String getTargetDatatype() {
		return targetDatatype;
	}

	public void setTargetDatatype(String targetDatatype) {
		this.targetDatatype = targetDatatype;
	}

	public boolean isIsPK() {
		return isPK;
	}

	public void setIsPK(boolean isPK) {
		this.isPK = isPK;
	}

	@Override
	public String toString() {
		return "DbfItem [id=" + id + ", dbfTypeId=" + dbfTypeId + ", fieldName=" + fieldName + ", fieldDatatype="
				+ fieldDatatype + ", position=" + position + ", targetTable=" + targetTable + ", targetColumn="
				+ targetColumn + ", targetDatatype=" + targetDatatype + ", isPK=" + isPK + "]";
	}

}
