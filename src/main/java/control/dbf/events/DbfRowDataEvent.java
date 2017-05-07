package control.dbf.events;

import java.util.List;

import entity.dbf.DbfRowData;
import entity.dbf.DbfRowDataProcessStatusEnum;

/**
 * DataContainer for DbfRowData
 * 
 * @author ngj
 *
 */
public class DbfRowDataEvent {

	private List<DbfRowData> dbfRowDatas;
	private DbfRowDataProcessStatusEnum processStatus;

	public DbfRowDataEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DbfRowDataEvent(List<DbfRowData> dbfRowDatas, DbfRowDataProcessStatusEnum processStatus) {
		super();
		this.dbfRowDatas = dbfRowDatas;
		this.processStatus = processStatus;
	}

	public List<DbfRowData> getDbfRowDatas() {
		return dbfRowDatas;
	}

	public void setDbfRowDatas(List<DbfRowData> dbfRowDatas) {
		this.dbfRowDatas = dbfRowDatas;
	}

	public DbfRowDataProcessStatusEnum getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(DbfRowDataProcessStatusEnum processStatus) {
		this.processStatus = processStatus;
	}

	@Override
	public String toString() {
		return "DbfRowDataEvent [#dbfRowDatas='" + dbfRowDatas.size() + "', UPDATE processStatus to '" + processStatus + "']";
	}

}
