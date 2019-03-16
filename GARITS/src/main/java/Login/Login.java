/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Account.Mechanic;
import Account.Staff;
import DatabaseConnect.DBConnect;
import DatabaseConnect.DBConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jorda
 */
public class Login {
    // objects for all methods to use
    Hashing hash = new Hashing(10);
    DBConnectivity db = new DBConnect();
    
    public boolean validateLogin(String user_name, String password) throws SQLException {
        
        try {
            // check username exists
            Connection conn = db.connect();
            String sql = "SELECT COUNT(user_name) AS counter FROM User WHERE user_name = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, user_name);
            ResultSet rs = p.executeQuery();
            
            if (rs.next()) {
                if (rs.getInt("counter") == 0) {
                    System.out.println("Invalid login username");
                    return false;
                }
            }
            
            db.closeConnection();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            Connection conn = db.connect();
            String sql = "SELECT password FROM User WHERE user_name = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, user_name);
            ResultSet rs = p.executeQuery();
            
            if (rs.next()) {
                String hashedPass = rs.getString("password");
                if (hash.verifyPassword(password, hashedPass)) {
                    System.out.println("Password matches");                                                           
                    return true;
                    
                }
                else {
                    System.out.println("Incorrect password");
                    return false;
                }
                
            }
            db.closeConnection();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
               
        return false;
        
        
        
    }
    
    public Staff createStaffObject(String user_name) throws SQLException {
        try {
            Staff staff = null;
            Connection conn = db.connect();
            String sql = "SELECT * FROM User WHERE user_name = ?";
            
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, user_name);
            
            ResultSet rs = p.executeQuery();
            
            if (rs.next()) {
                String db_user_name = rs.getString("user_name"); // login username
                String password = rs.getString("password");
                String user_role = rs.getString("user_role");
                String name = rs.getString("username");
                
                // default pay is 0
                staff = new Mechanic(db_user_name, password, user_role, name, 0);
                switch(user_role) {
                    case "Receptionist":
                        staff = new Staff(db_user_name, password, user_role, name);
                }
            }
            return staff;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // if null is returned, an error has occured
        return null;
    }
    
    public void addUser(String username, String password, String role, String name) throws SQLException {        
        Staff userToAdd = new Staff(username, hash.hashPassword(password), role, name);
        //TODO: hash password
        
        
        switch(role) {             
            case "Mechanic":
            case "Foreperson":
                // 0 is default user pay
                userToAdd = new Mechanic(username, hash.hashPassword(password), role, name, 0);
                
        }
        
        // add the user to the database
        // name is now the login username, and username is the uers' full name
        // (forename and surname)
        // had to swap round for other code
        try {
            Connection conn = db.connect();
            String sql = "INSERT INTO User(username, password, user_role, user_name) VALUES (?, ?, ?, ?)";
            PreparedStatement p =conn.prepareStatement(sql);
            p.setString(1, userToAdd.getName()); // user_name
            p.setString(2, userToAdd.getPassword());
            p.setString(3, userToAdd.getRole());
            p.setString(4, userToAdd.getUsername()); // username
            p.executeUpdate();
            System.out.println("Added " + userToAdd.getName() + " to the database");
            System.out.println("Added user of type class " + userToAdd.getClass() + " to the database");
            db.closeConnection();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
}
