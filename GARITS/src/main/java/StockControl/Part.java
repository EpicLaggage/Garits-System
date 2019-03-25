package StockControl;

import Account.*;
import DatabaseConnect.DBConnect;
import DatabaseConnect.DBConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        
        public Part() {}
        
        
        
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

        public int getPartID() {
            return partID;
        }

        public void setPartID(int partID) {
            this.partID = partID;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getThreshold() {
            return threshold;
        }

        public void setThreshold(int threshold) {
            this.threshold = threshold;
        }
        
        
        
        

    @Override
    public String toString() {
        return "Part{" + "partID=" + partID + ", name=" + name + ", manufacturer=" + manufacturer + ", price=" + price + ", vehicleType=" + vehicleType + ", year=" + year + ", qty=" + qty + ", supplier=" + supplier.getName() + ", threshold=" + threshold + '}';
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
        
        public ArrayList<Part> getAllParts() {
            DBConnectivity db = new DBConnect();
            ArrayList<Part> allParts = new ArrayList<>();
            Connection conn = db.connect();
            try {
                conn.setAutoCommit(false);
                String sql = "SELECT * FROM Parts";
                PreparedStatement partQuery = conn.prepareStatement(sql);
                ResultSet rs = partQuery.executeQuery();

                conn.commit();
                while (rs.next()) {
                    Part partToAdd = new Part(rs.getString("part_name"), rs.getString("part_manufacturer"), new Supplier(rs.getInt("part_supplier_id")), rs.getString("vehicle_type"), rs.getFloat("part_price"), rs.getInt("year"), rs.getInt("part_quantity"), rs.getInt("part_threshold"));
                    partToAdd.setPartID(rs.getInt("part_id"));
                    allParts.add(partToAdd);
                    
                }
                
                conn.setAutoCommit(true);
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
                try {
                    conn.rollback();
                }
                catch (SQLException e2) {
                    System.out.println(e2.getMessage());
                }
                
            }
            finally {
                
                db.closeConnection();
            }
           
            
            
            return allParts;
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