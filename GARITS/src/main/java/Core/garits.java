/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.sql.*;
import DatabaseConnect.DBConnect;
import java.sql.*;

/**
 *
 * @author jly09
 */
public class garits {

    DBConnect dbConnect;
    
    public garits() {
        dbConnect = new DBConnect();
        ResultSet rs;
        //String sql = "SELECT * FROM Customer";
        String sql = "INSERT INTO Customer (customer_name,customer_address,customer_postcode,customer_tel,customer_email) VALUES ('Adam','79 Landon Yard, London','E6 3R2','02078957890','adamhills@outlook.com')";
        /*try {
            rs = dbConnect.read(sql);
            
            while(rs.next()) {
                System.out.println(rs.getString("customer_name"));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }*/
        
        try {
            dbConnect.write(sql);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        new garits();
        /*Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        String user = "root";
        String pass = "Password1";
        
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", user, pass);
            
            myStmt = myConn.createStatement();
            
            myRs = myStmt.executeQuery("select * from user");
            
            while (myRs.next()) {
                int id = myRs.getInt("ID");
                String name = myRs.getString("Name");
                
                System.out.println("ID: " + id + ", Name: " + name);
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }
            
            if (myStmt != null) {
                myStmt.close();
            }
            
            if (myConn != null) {
                myConn.close();
            }
        }*/
        
        try {
            
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
}
