package Report;

import java.util.Date;
import Account.*;
import java.util.List;

public class NumOfVehicles extends Reports {

	private String filter;
	private String name;
	private List<Vehicle> vehicles;
	private Customer[] customers;
	private String job_type;
	private Date period;

	/**
	 * 
	 * @param report_name
	 * @param date
	 * @param filter
	 * @param name
	 * @param vehicles
	 * @param period
	 */
	public NumOfVehicles(String report_name, Date date, String name, List<Vehicle> vehicles, Date period) {
		super(report_name, date);
                
                this.vehicles = vehicles;
	}

	/**
	 * 
	 * @param report_name
	 * @param date
	 * @param filter
	 * @param name
	 * @param vehicles
	 * @param job_type
	 */
	public NumOfVehicles(String report_name, Date date, String name, Vehicle[] vehicles, String job_type) {
		super(report_name, date);
	}
        
        public NumOfVehicles(String report_name, Date date, String filter, List<Vehicle> vehicles) {
		super(report_name, date);
                
                this.vehicles = vehicles;
                
                if (filter == "Overall") {
                    
                }
                if (filter == "") {
                    
                }
	}

	/**
	 * 
	 * @param report_name
	 * @param date
	 * @param filter
	 * @param name
	 * @param vehicles
	 * @param cust
	 */

	public void GenerateReport() {
		// TODO - implement NumOfVehicles.GenerateReport
		throw new UnsupportedOperationException();
	}

}