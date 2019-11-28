import java.util.ArrayList;
import java.util.Date;

enum OrderStatus{
    NEW, HOLD, SHIPPED, DELIVERED, CLOSED;
}

public class Order {

    private String name;
    private Date ordered;
    private Date shipped;
    private Address ship_to;
    private OrderStatus status;
    private float total;
    private ArrayList<LineItem> lineItems;
    private ArrayList<Payment> payments;

    public Order(String name, Date ordered, Date shipped, Address ship_to, float total) {
        this.name = name;
        this.ordered = ordered;
        this.shipped = shipped;
        this.ship_to = ship_to;
        this.total = total;
        this.status=OrderStatus.NEW;
        lineItems = new ArrayList<>();
        payments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Date getOrdered() {
        return ordered;
    }

    public Date getShipped() {
        return shipped;
    }

    public Address getShip_to() {
        return ship_to;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public float getTotal() {
        return total;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrdered(Date ordered) {
        this.ordered = ordered;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    public void setShip_to(Address ship_to) {
        this.ship_to = ship_to;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean addLineItem(LineItem lineItem){
        if(lineItem == null){
            return false;
        }
        if(lineItems.contains(lineItem)){
            return false;
        }
        else if(this.equals(lineItem.getOrder())){
            lineItems.add(lineItem);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteLineItem(LineItem lineItem){
        if(lineItem == null){
            return false;
        }
        if(lineItems.contains(lineItem)){
            lineItems.remove(lineItem);
            return true;
        }
        else{
            return false;
        }
    }



    public boolean addPayment(Payment payment){
        if(payment == null){
            return false;
        }
        if(payments.contains(payment)){
            return false;
        }
        else if(this.equals(payment.getOrder())){
            payments.add(payment);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deletePayment(Payment payment){
        if(payment == null){
            return false;
        }
        if(payments.contains(payment)){
            payments.remove(payment);
            return true;
        }
        else{
            return false;
        }
    }



}
