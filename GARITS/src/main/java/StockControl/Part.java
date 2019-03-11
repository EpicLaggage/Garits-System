package StockControl;

import Account.*;

public class Part {

	private int num;
	private String name;
	private String manufacturer;
	private String description;
	private float price;
	private int qty;
	private Supplier supplier;

	/**
	 * 
	 * @param no
	 * @param name
	 * @param manu
	 * @param desc
	 * @param sup
	 */
	public Part(int no, String name, String manu, String desc, Supplier sup) {
		// TODO - implement Part.Part
		throw new UnsupportedOperationException();
	}

	public int getNum() {
		return this.num;
	}

	/**
	 * 
	 * @param num
	 */
	public void setNum(int num) {
		this.num = num;
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

	public String getManufacturer() {
		return this.manufacturer;
	}

	/**
	 * 
	 * @param manufacturer
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	public int getQty() {
		return this.qty;
	}

	/**
	 * 
	 * @param qty
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	/**
	 * 
	 * @param supplier
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * 
	 * @param name
	 * @param qty
	 * @param role
	 */
	public Staff generateAlert(String name, int qty, String role) {
		return null;
	}

}