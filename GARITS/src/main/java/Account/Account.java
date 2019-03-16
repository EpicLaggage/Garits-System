package Account;

public class Account {

	private String name;
	private String email;
	private int phone;
	private String address;

        public Account() {
        }

    
	/**
	 * 
	 * @param name
	 * @param email
	 * @param phone
	 * @param address
	 */
        public Account(String name, String email, int phone, String address) {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.address = address;
        }	

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return this.phone;
	}

	/**
	 * 
	 * @param phone
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}