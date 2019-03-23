package StockControl;

import DatabaseConnect.DBConnect;
import DatabaseConnect.DBConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public Supplier(String name, String address, int phone, String email) {
		this.name = name;
                this.address = address;
                this.phone = phone;
                this.email = email;
	}

        DBConnectivity db = new DBConnect();
        
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

        
        // boolean to indicate whether adding supplier to db was successful
        public boolean addSupplierToDB() throws SQLException {
            Connection conn = db.connect();
            try {
                // use of transactions
                conn.setAutoCommit(false);
                String sql = "INSERT INTO Supplier(supplier_name, supplier_address, supplier_tel, supplier_email) VALUES (?, ?, ?, ?)";
                PreparedStatement p = conn.prepareStatement(sql);
                p.setString(1, this.name);
                p.setString(2, this.address);
                p.setInt(3, this.phone);
                p.setString(4, this.email);
                p.executeUpdate();
                conn.commit();
                conn.setAutoCommit(true);
                return true;
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
                // if an error occurs, roll back the changes made to the db
                conn.rollback();
                return false;
            }
            finally {
                db.closeConnection();
            }
            
            
        }
        
        
}