package Processing;

public class Invoice {

	private int num;
	private String payment_type;
	private boolean pending;
	private float amount;

	/**
	 * 
	 * @param payType
	 */
	public Invoice Invoice(String payType) {
		// TODO - implement Invoice.Invoice
		throw new UnsupportedOperationException();
	}

	public int getNum() {
		return this.num;
	}

	/**
	 * 
	 * @param num
	 */
	public void setNum(int num) {
		this.num = num;
	}

	public String getPayment_type() {
		return this.payment_type;
	}

	/**
	 * 
	 * @param payment_type
	 */
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public boolean getPending() {
		return this.pending;
	}

	/**
	 * 
	 * @param pending
	 */
	public void setPending(boolean pending) {
		this.pending = pending;
	}

	public float getAmount() {
		return this.amount;
	}

	/**
	 * 
	 * @param amount
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

}