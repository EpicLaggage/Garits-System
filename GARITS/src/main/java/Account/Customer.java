package Account;

public class Customer extends Account {
    
        private boolean accountHolder;
	private Vehicle[] vehicles;
        
        

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
        public Customer(boolean accountHolder, Vehicle[] vehicles, String name, String email, int phone, String address) {
            super(name, email, phone, address);
            this.accountHolder = accountHolder;
            this.vehicles = vehicles;
        }

        public boolean isAccountHolder() {
            return accountHolder;
        }

        public void setAccountHolder(boolean accountHolder) {
            this.accountHolder = accountHolder;
        }

        public Vehicle[] getVehicles() {
            return vehicles;
        }

        public void setVehicles(Vehicle[] vehicles) {
            this.vehicles = vehicles;
        }
        
        
}