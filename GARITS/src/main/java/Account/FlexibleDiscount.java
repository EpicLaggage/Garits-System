package Account;

public class FlexibleDiscount implements DiscountPlan {

    private float percentage = 0;
    private boolean available;
    String type = null;

    /**
     *
     * @param p
     */
    public FlexibleDiscount(float p) {
        percentage = p;
        type = "Flexible Discount";
    }
    
    public FlexibleDiscount() {
        type = "Flexible Discount";
    }

    public void Calculate() {
        
    }

    /**
     *
     * @param percentage
     */
    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
    
    public float getPercentage() {
        return percentage;
    }

}
