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

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        new garits();
        Thread getTime = new DetectLatePayment();
        getTime.start();
        
        try {
            
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
}
