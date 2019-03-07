package StockControl;

public class Supplier {

	private String name;
	private String address;
	private int phone;
	private String email;

	/**
	 * 
	 * @param n
	 * @param addr
	 * @param phone
	 * @param email
	 */
	public Supplier(String n, String addr, int phone, String email) {
		// TODO - implement Supplier.Supplier
		throw new UnsupportedOperationException();
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

}