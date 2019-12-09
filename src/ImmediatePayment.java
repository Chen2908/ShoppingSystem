public class ImmediatePayment extends Payment {

    private boolean phoneConfirmation;

    public ImmediatePayment(float total, String details, Order order, Account account) {
        super(total,details,order, account);
        this.phoneConfirmation = false;
    }

    public boolean getPhoneConfirmation() {
        return phoneConfirmation;
    }

    public void setPhoneConfirmation(boolean phoneConfirmation) {
        this.phoneConfirmation = phoneConfirmation;
    }

    @Override
    public void addAccount(Account account, int percent) {
        if (account != null) {
            if (!accounts.contains(account)) {
                accounts.add(account);
                PartInPayment partInPayment = new PartInPayment(account, this, percent);
            }
        }
    }
}
