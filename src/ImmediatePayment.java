public class ImmediatePayment extends Payment {

    private boolean phoneConfirmation;

    public ImmediatePayment(String id, float total, String details) {
        super(id, total, details);
        this.phoneConfirmation = false;
    }

    public boolean getPhoneConfirmation() {
        return phoneConfirmation;
    }

    public void setPhoneConfirmation(boolean phoneConfirmation) {
        this.phoneConfirmation = phoneConfirmation;
    }
}
