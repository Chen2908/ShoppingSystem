import java.util.ArrayList;
import java.util.Date;

public class Account {
    protected String id;
    protected String billing_Address;
    protected boolean is_Closed;
    protected Date open;
    protected Date close;
    protected int balance;
    protected ArrayList<Order> orders;
    protected ArrayList<Payment> payments;
    protected Customer customer;
    protected ShoppingCart shoppingCart;

    public Account(String id, String billing_Address, Date open, Date close, int balance, Customer customer,ShoppingCart shoppingCart) {
        this.id = id;
        this.billing_Address = billing_Address;
        this.is_Closed = false;
        this.open = open;
        this.close = close;
        this.balance = balance;
        this.orders = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.customer = customer;
        this.shoppingCart = shoppingCart;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBilling_Address() {
        return billing_Address;
    }

    public void setBilling_Address(String billingAddress) {
        this.billing_Address = billingAddress;
    }

    public boolean is_Closed() {
        return is_Closed;
    }

    public void setClosed(boolean closed) {
        is_Closed = closed;
    }

    public Date getOpen() {
        return open;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public Date getClose() {
        return close;
    }

    public void setClose(Date close) {
        this.close = close;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Order getLastOrder() {
        return this.orders.get(orders.size() - 1);
    }

    public Payment getLastPayment() {
        return this.payments.get(payments.size() - 1);
    }

    public boolean addOrder(Order order) {
        if (order != null) {

            if (!orders.contains(order)) {
                orders.add(order);
                order.setAccount(this);
                return true;
            }
        }
        return false;

    }


    public void deleteOrder(Order order) {
        if (order != null) {
            if (orders.contains(order)) {
                order.deleteAccount();
                orders.remove(order);
            }
        }

    }

    public boolean addPayment(Payment payment, int precent) {
        if (payment != null) {

            if (!payments.contains(payment)) {
                payments.add(payment);
                payment.addAccount(this,precent);

                return true;
            }

        }
        return false;
    }

    public void deletePayment(Payment payment) {
        if(payment != null){
            if(payments.contains(payment)){
                payments.remove(payment);

            }
        }
    }
    public void deleteCustomer(){
        Customer existCustomer = this.customer;
        customer = null;
        if(existCustomer != null){
            existCustomer.deleteAccount();
        }
    }

    public void deleteShoppingCart() {
        ShoppingCart existShoppingCart = this.shoppingCart;
        shoppingCart = null;
        if(existShoppingCart != null){
            existShoppingCart.deleteAccount();
        }
    }
}
