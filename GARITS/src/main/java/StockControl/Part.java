package StockControl;

import Account.*;
import DatabaseConnect.DBConnect;
import DatabaseConnect.DBConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Part {

	private int partID;
	private String name;
	private String manufacturer;
	private float price;
        private String vehicleType;
        private int year;
	private int qty;
	private Supplier supplier;
        private int threshold;
        

	/**
	 * 
	 * @param partID
	 * @param name
	 * @param manu
	 * @param desc
	 * @param sup
	 */
	public Part(String name, String manu, Supplier sup, String vehicleType, float price, int year, int qty, int threshold) {
		this.name = name;
                this.manufacturer = manu;
                this.supplier = sup;
                this.vehicleType = vehicleType;
                this.price = price;
                this.year = year;
                this.qty = qty;
                this.threshold = threshold;
                
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
        
        public boolean addPart() throws SQLException {
            DBConnectivity db = new DBConnect();
            Connection conn = db.connect();
            try {
                conn.setAutoCommit(false);
                String sql = "INSERT INTO Parts(part_name, part_manufacturer, part_supplier_id, vehicle_type, year, part_quantity, part_price, part_threshold) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement p = conn.prepareStatement(sql);
                p.setString(1, this.name);
                p.setString(2, this.manufacturer);
                p.setInt(3, this.supplier.getSupplierID());
                p.setString(4, this.vehicleType);
                p.setInt(5, this.year);
                p.setInt(6, this.qty);
                p.setFloat(7, this.price);
                p.setInt(8, this.threshold);
                p.executeUpdate();
                conn.commit();
                conn.setAutoCommit(true);
                return true;
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
                conn.rollback();
                return false;
            }
            finally {
                db.closeConnection();
            }
            
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