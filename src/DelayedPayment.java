
import java.time.LocalDateTime;
import java.util.Date;

public class DelayedPayment extends Payment {

    private Date paymentDate;

    public DelayedPayment(float total, String details, Date paymentDate, Order order, Account account) {
        super(total,details,order, account);
        this.paymentDate = paymentDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
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
