abstract class Payment {

    protected String id;
    protected float total;
    protected String details;

    public Payment(String id, float total, String details) {
        this.id = id;
        this.total = total;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public float getTotal() {
        return total;
    }

    public String getDetails() {
        return details;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
