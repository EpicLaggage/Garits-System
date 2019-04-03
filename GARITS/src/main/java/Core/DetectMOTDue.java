/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Account.Customer;
import DatabaseConnect.DBConnect;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
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

    public DetectMOTDue() {
        dbConnect = new DBConnect();
    }
    
    
    public void run(){

        // TODO check if user is franchisee
        while(true){
            
            if(!reminderSnoozed) {
                //Adding 5 working days to date
                Date date=new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
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
                String motDate = dateFormat.format(date);
                System.out.println(motDate);
                
                String latePaymentsQuery = "SELECT * FROM garitsdb.Invoice WHERE"
                        + " invoice_paid = '0' AND payment_due_date <= '" 
                        + calendar + "';";

            }
            
            //do check for user role here
            if(!motReminders.isEmpty()){
                int reply = JOptionPane.showConfirmDialog(null,
                        "Do you want to MOT reminders?",
                        "MOT reminder", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
//                  RemindersForm reminders = new RemindersForm(
//                          unpaidInvoices);
//                  reminders.setVisible(true);
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
                    Thread.sleep(5000);//900000
            }
            catch(InterruptedException e)
            {}
        }

    }
}
