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
import java.sql.SQLException;

/**
 *
 * @author jorda
 */
public class Login {
    Hashing hash = new Hashing(10);
    
    public void processLogin(Staff staff) {

    }
    
    public void addUser(String username, String password, String role, String name) throws SQLException {
        DBConnectivity db = new DBConnect();
        Staff userToAdd = new Staff(username, hash.hashPassword(password), role, name);
        //TODO: hash password
        
        
        switch(role) {             
            case "Mechanic":
            case "Foreperson":
                // 0 is default user pay
                userToAdd = new Mechanic(username, hash.hashPassword(password), role, name, 0);
                System.out.println(userToAdd.getClass());
                
        }
        
        // add the user to the database
        try {
            Connection conn = db.connect();
            String sql = "INSERT INTO User(username, password, user_role, user_name) VALUES (?, ?, ?, ?)";
            PreparedStatement p =conn.prepareStatement(sql);
            p.setString(1, userToAdd.getUsername());
            p.setString(2, userToAdd.getPassword());
            p.setString(3, userToAdd.getRole());
            p.setString(4, userToAdd.getName());
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
