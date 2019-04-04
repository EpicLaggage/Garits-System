/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Account.Customer;
import Account.Vehicle;
import DatabaseConnect.DBConnect;
import GUI.MotRemindersForm;
import java.util.List;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author paul
 */
public class DetectMOTDue extends Thread {
    DBConnect dbConnect;
    ArrayList<Customer> motReminders = new ArrayList<Customer>();
    boolean reminderSnoozed = false;
    String motDate;
    Control control;

    public DetectMOTDue(Control c) {
        dbConnect = new DBConnect();
        this.control = c;
    }
    
    
    public void run(){

        // TODO check if user is franchisee
        while(true){
            
            if(!reminderSnoozed) {
                //Adding 5 working days to date
                Date date=new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                date=calendar.getTime();
                int days = 5;
                for(int i=0;i<days;)
                {
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                    //here even sat and sun are added
                    //but at the end it goes to the correct week day.
                    //because i is only increased if it is week day
                    if(calendar.get(Calendar.DAY_OF_WEEK)<=5)
                    {
                        i++;
                    }

                }            
                date=calendar.getTime();
                motDate = dateFormat.format(date);
                
                
                String motDueQuery = "SELECT * FROM garitsdb.Vehicle, "
                        + "garitsdb.Customer WHERE garitsdb.Customer.customer_account_holder = '1' \n" +
                        "AND garitsdb.Vehicle.customer_id =  garitsdb.Customer.customer_id\n" +
                        "AND garitsdb.Vehicle.purchase_date LIKE '____-"+motDate.substring(5) + "';";
                ResultSet rs; 
                try {
                    rs = dbConnect.read(motDueQuery);

                    while(rs.next()) {
                        Customer customer = new Customer();
                        Vehicle vehicle = new Vehicle();
                        List<Vehicle> vehicles = new ArrayList<Vehicle>();
                        vehicle.setReg_num(rs.getString("reg_no"));
                        customer.setName(rs.getString("customer_name"));
                        customer.setAddress(rs.getString("customer_address"));
                        customer.setPostcode(rs.getString("customer_postcode"));
                        vehicles.add(vehicle);
                        customer.setVehicles(vehicles);
                        motReminders.add(customer);
                        
                    }

                }
                catch (Exception exc) {
                    exc.printStackTrace();
                }

            }
            
            
            //do check for new date here
            if(!motReminders.isEmpty()){
                int reply = JOptionPane.showConfirmDialog(null,
                        "Do you want to MOT reminders?",
                        "MOT reminder", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                  MotRemindersForm reminders = new MotRemindersForm(
                          motReminders, motDate);
                  reminders.setVisible(true);
                  motReminders.clear();
                  reminderSnoozed = false;
                }
                else {
                   JOptionPane.showMessageDialog(null, "Snoozed for 15 minutes");
                   reminderSnoozed = true;
                }
            }

            // sleep pauses thread execution for 15 minutes below

            try {
                    Thread.sleep(900000);//900000
            }
            catch(InterruptedException e)
            {}
        }

    }
}
