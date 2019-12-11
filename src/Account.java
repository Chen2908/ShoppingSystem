import java.util.ArrayList;
import java.util.Date;

public class Account {
    public static int generateId=0;

    protected String id;
    protected Address billing_Address;
    protected boolean is_Closed;
    protected Date open;
    protected Date close;
    protected int balance;
    protected ArrayList<Order> orders;
    protected ArrayList<Payment> payments;
    protected Customer customer;
    protected ShoppingCart shoppingCart;

    public Account(Customer customer, ShoppingCart shoppingCart) {
        this.id = Integer.toString(generateId);
        this.billing_Address = null;
        this.is_Closed = false;
        this.open = new Date();
        this.close = null;
        this.balance = 0;
        this.orders = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.customer = customer;
        this.shoppingCart = shoppingCart;
        generateId++;
    }

    public Account(Address address, String phone, String email, WebUser webuser){
        this.id = Integer.toString(generateId);
        this.billing_Address = address;
        this.is_Closed = false;
        this.open = new Date();
        this.close = null;
        this.balance = 0;
        this.orders = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.customer = new Customer(address, phone, email, this);
        this.shoppingCart = new ShoppingCart(this, webuser);
        generateId++;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public Address getBilling_Address() {
        return billing_Address;
    }

    public void setBilling_Address(Address billingAddress) {
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
    public int getNumOfOrder(){
        return this.orders.size();
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
