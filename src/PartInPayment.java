public class PartInPayment {

    private Account account;
    private Payment payment;
    private int percent;

    public PartInPayment(Account account, Payment payment, int percent) {
        this.account = account;
        this.payment = payment;
        this.percent = percent;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
