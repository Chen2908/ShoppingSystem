import java.util.Date;

public class Account {
    protected String id;
    protected String billing_Address;
    protected boolean is_Closed;
    protected Date open;
    protected  Date close;
    protected int balance;

    public Account(String id, String billing_Address, Date open, Date close, int balance) {
        this.id = id;
        this.billing_Address = billing_Address;
        this.is_Closed = false;
        this.open = open;
        this.close = close;
        this.balance = balance;
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
}
