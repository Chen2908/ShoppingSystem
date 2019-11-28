
import java.time.LocalDateTime;
public class DelayedPayment extends Payment {

    private LocalDateTime paymentDate;

    public DelayedPayment(String id, float total, String details, LocalDateTime paymentDate) {
        super(id, total, details);
        this.paymentDate = paymentDate;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}
