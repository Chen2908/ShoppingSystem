
import java.time.LocalDateTime;
public class DelayedPayment extends Payment {

    private LocalDateTime paymentDate;

    public DelayedPayment(String id, float total, String details, LocalDateTime paymentDate,Order order, Account account) {
        super(id,total,details,order, account);
        this.paymentDate = paymentDate;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
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
