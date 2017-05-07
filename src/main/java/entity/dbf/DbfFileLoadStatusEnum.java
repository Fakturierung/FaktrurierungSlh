package entity.dbf;

/**
 * 
 * @author ngj
 *
 */
public enum DbfFileLoadStatusEnum {

	INITIAL(0), PROCESSING(1), TERMINATED(2), FAILED(-1), UNDEFINIED(-2);

	private int processStatus;

	private DbfFileLoadStatusEnum(int statusValue) {
		this.processStatus = statusValue;
	}

	public int getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(int processStatus) {
		this.processStatus = processStatus;
	}

}
