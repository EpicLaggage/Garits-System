package Account;

import java.util.List;

public class Customer extends Account {
    
        private boolean accountHolder;
        private int customerId;
	private List<Vehicle> vehicles;
        private String postcode;
        
        

        public Customer() {}
                
    	/**
	 * 
         * @param accountHolder
         * @param vehicles
	 * @param name
	 * @param email
	 * @param phone
	 * @param address
	 */
        public Customer(boolean accountHolder, int customerId, List<Vehicle> vehicles, String name, String email, String phone, String address) {
            super(name, email, phone, address);
            this.accountHolder = accountHolder;
            this.customerId = customerId;
            this.vehicles = vehicles;
        }

        public boolean isAccountHolder() {
            return accountHolder;
        }

        public void setAccountHolder(boolean accountHolder) {
            this.accountHolder = accountHolder;
        }

        public List<Vehicle> getVehicles() {
            return vehicles;
        }

        public void setVehicles(List<Vehicle> vehicles) {
            this.vehicles = vehicles;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
        
        
        
             
        
}