import java.util.ArrayList;
import java.util.Date;

enum OrderStatus{
    NEW, HOLD, SHIPPED, DELIVERED, CLOSED;
}

public class Order {
    public static int generateId=0;

    private String number;
    private Date ordered;
    private Date shipped;
    private Address ship_to;
    private OrderStatus status;
    private float total;
    private ArrayList<LineItem> lineItems;
    private ArrayList<Payment> payments;
    private Account account;


    public Order(Address ship_to, Account account) {
        this.number = Integer.toString(generateId);
        this.ordered = new Date();
        this.shipped = null;
        this.ship_to = ship_to;
        this.total = 0;
        this.status = OrderStatus.NEW;
        lineItems = new ArrayList<>();
        payments = new ArrayList<>();
        this.account = account;
        generateId++;
    }

    public String getNumber() {
        return number;
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

    public void setNumber(String number) {
        this.number = number;
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

    @Override
    public String toString(){
        String order = "Order number: " + this.number + "\n " +
                        "Date of order: " + ordered + "\n " +
                        "Ship to : " + ship_to + "\n " +
                        "Status: " + status + "\n" +
                        "Total payment: " + total + "\n";
        return order;
    }

    public Account getAccount() {
        return account;
    }

    public boolean addLineItem(LineItem lineItem){
        if(lineItem == null || lineItems.contains(lineItem)){
            return false;
        }
        Order _order = lineItem.getOrder();
        if(_order != null && !this.equals(_order)){
            _order.removeLineItem(lineItem);
            lineItem.setOrder(this);
            lineItems.add(lineItem);
            return true;
        }
        else{
            lineItems.add(lineItem);
            return true;
        }
    }

    public boolean removeLineItem(LineItem lineItem){
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
            payment.deleteOrder();
            payments.remove(payment);

            return true;
        }
        else{
            return false;
        }
    }


    public void deleteAccount() {
        this.account = null;
    }


    public boolean setAccount(Account account) {

            if(account == null){
                return false;
            }

            Account exisAccount = this.account;
            this.account = account;
            if(exisAccount != null && !exisAccount.equals(account)){
                exisAccount.deleteOrder(this);
            }
        account.addOrder(this);
            return true;
    }

    public void deleteOrder(){
        for(LineItem lineItem: lineItems){
            lineItem.deleteLineItem();
        }
    }

}

