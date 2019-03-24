package StockControl;

import Account.*;

public class Part {

	private int partId;
	private String name;
	private String manufacturer;
	private String description;
	private float price;
	private int qty;
	private int supplierId;
        private int partUsedId;

    public Part() {
    }

    public Part(int partId, String name, String manufacturer, String description, float price, int qty, int supplierId) {
        this.partId = partId;
        this.name = name;
        this.manufacturer = manufacturer;
        this.description = description;
        this.price = price;
        this.qty = qty;
        this.supplierId = supplierId;
    }


	public int getPartId() {
		return this.partId;
	}

	/**
	 * 
	 * @param num
	 */
	public void setPartId(int partId) {
		this.partId = partId;
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

	public int getSupplierId() {
		return this.supplierId;
	}

	/**
	 * 
	 * @param supplierId
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
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

    public int getPartUsedId() {
        return partUsedId;
    }

    public void setPartUsedId(int partUsedId) {
        this.partUsedId = partUsedId;
    }
        
        

}