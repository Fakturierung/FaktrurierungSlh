package entity.dbf;

/**
 * 
 * @author ngj
 *
 */
public enum DbfRowDataProcessStatusEnum {

	INITIAL(0), PROCESSING(1), TERMINATED(2), ERROR(-1);

	private final int status;

	private DbfRowDataProcessStatusEnum(int value) {
		this.status = value;
	}

	public int getStatus() {
		return status;
	}

}
