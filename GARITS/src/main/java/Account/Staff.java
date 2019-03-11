package Account;

public class Staff extends Account {

	private String id;
	private char password;
	private String role;
	private float hourly_rate;

	/**
	 * 
	 * @param id
	 * @param pass
	 * @param role
	 * @param pay
	 * @param n
	 * @param email
	 * @param phone
	 * @param addr
	 */
	public Staff Staff(String id, char pass, String role, float pay, String n, String email, int phone, String addr) {
		// TODO - implement Staff.Staff
		throw new UnsupportedOperationException();
	}

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public char getPassword() {
		return this.password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(char password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	/**
	 * 
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	public float getHourlyRate() {
		// TODO - implement Staff.getHourlyRate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param hourly_rate
	 */
	public void setHourlyRate(float hourly_rate) {
		// TODO - implement Staff.setHourlyRate
		throw new UnsupportedOperationException();
	}

	public void checkAlerts() {
		// TODO - implement Staff.checkAlerts
		throw new UnsupportedOperationException();
	}

}