package Account;

public class AccountHolder extends Customer {

	private DiscountPlan discount_plan;
	private boolean pay_later;
        
        public AccountHolder(String name, String email, int phone, String address) {
            super(name, email, phone, address);
        }

	public DiscountPlan getDiscount_plan() {
		return this.discount_plan;
	}

	/**
	 * 
	 * @param discount_plan
	 */
	public void setDiscount_plan(DiscountPlan discount_plan) {
		this.discount_plan = discount_plan;
	}

	public boolean getPay_later() {
		return this.pay_later;
	}

	/**
	 * 
	 * @param pay_later
	 */
	public void setPay_later(boolean pay_later) {
		this.pay_later = pay_later;
	}

}