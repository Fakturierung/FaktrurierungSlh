package control.dbf.events;

import entity.dbf.DbfRowData;
import entity.dbf.DbfRowDataProcessStatusEnum;

public class MonitorEvent {

	private DbfRowData data;
	private DbfRowDataProcessStatusEnum status;

	public MonitorEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonitorEvent(DbfRowData rowData2Update, DbfRowDataProcessStatusEnum status2Update) {
		this.data = rowData2Update;
		this.status = status2Update;
	}

	public DbfRowData getData() {
		return data;
	}

	public void setData(DbfRowData data) {
		this.data = data;
	}

	public DbfRowDataProcessStatusEnum getStatus() {
		return status;
	}

	public void setStatus(DbfRowDataProcessStatusEnum status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MonitorEvent [data=" + data + ", status=" + status + "]";
	}

}
