package Processing;

public class Invoice {

	private int invoiceId;
	private String payment_type;
	private boolean isPaid;
	private float amountDue;
        private int jobId;
        private String jobStart;
	private String jobEnd;
        private int customerId;
        private String customerName;
        private boolean accountHolder;
        private String customerEmail;
        private int customerPhone;
        private String customerAddress;
        private boolean paymentReminder;
        

	/**
	 * 
	 * @param payType
	 */
	public Invoice Invoice(String payType) {
		// TODO - implement Invoice.Invoice
		throw new UnsupportedOperationException();
	}

    public Invoice() {
    }
        
        public float calcMarkUpSpares(float sparePartsTotal) {
            float markUp = (float) (sparePartsTotal * 1.3);
            return markUp;
        }
        
        public float calcLabourCost(float hoursWorked, float wage) {
            return hoursWorked*wage;
        }
        
        //Adds VAT to payment total
        public float calcPaymentTotal(float labourCost, float sparePartsCost) {
            return (float) ((labourCost+sparePartsCost) * 1.2);
        }

        public int getJobId() {
            return jobId;
        }

        public void setJobId(int jobId) {
            this.jobId = jobId;
        }

        public String getJobStart() {
            return jobStart;
        }

        public void setJobStart(String jobStart) {
            this.jobStart = jobStart;
        }

        public String getJobEnd() {
            return jobEnd;
        }

        public void setJobEnd(String jobEnd) {
            this.jobEnd = jobEnd;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public boolean isAccountHolder() {
            return accountHolder;
        }

        public void setAccountHolder(boolean accountHolder) {
            this.accountHolder = accountHolder;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }

        public void setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
        }

        public int getCustomerPhone() {
            return customerPhone;
        }

        public void setCustomerPhone(int customerPhone) {
            this.customerPhone = customerPhone;
        }

        public String getCustomerAddress() {
            return customerAddress;
        }

        public void setCustomerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
        }

        public boolean isPaymentReminder() {
            return paymentReminder;
        }

        public void setPaymentReminder(boolean paymentReminder) {
            this.paymentReminder = paymentReminder;
        }
        
        

	public int invoiceId() {
		return this.invoiceId;
	}

	/**
	 * 
	 * @param invoiceId
	 */
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
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

	public boolean getIsPaid() {
		return this.isPaid;
	}

	/**
	 * 
	 * @param isPaid
	 */
	public void setIsPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public float getAmountDue() {
		return this.amountDue;
	}

	/**
	 * 
	 * @param amountDue
	 */
	public void setAmountDue(float amountDue) {
		this.amountDue = amountDue;
	}

}