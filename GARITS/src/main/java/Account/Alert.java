package Account;

public class Alert {

	private String message;
	private boolean read;

	/**
	 * 
	 * @param message
	 */
	public Alert Alert(String message) {
		// TODO - implement Alert.Alert
		throw new UnsupportedOperationException();
	}

	public String getMessage() {
		return this.message;
	}

	/**
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getRead() {
		return this.read;
	}

	/**
	 * 
	 * @param read
	 */
	public void setRead(boolean read) {
		this.read = read;
	}

}