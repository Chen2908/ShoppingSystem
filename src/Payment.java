import java.util.ArrayList;

abstract class Payment {
    public static int generateId=0;
    protected String id;
    protected float total;
    protected String details;
    protected Order order;
    protected ArrayList<Account> accounts;

    public Payment( float total, String details, Order order, Account account) {
        this.id = Integer.toString(generateId);
        this.total = total;
        this.details = details;
        this.order = order;
        this.accounts = new ArrayList<>();
        addAccount(account,100);
        generateId++;

    }

    public String getId() {
        return id;
    }

    public float getTotal() {
        return total;
    }

    public String getDetails() {
        return details;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Order getOrder (){
        return order;
    }



    public boolean setOrder(Order order){
        if(order == null){
            return false;
        }
        Order exisOrder = this.order;
        this.order = order;
        if(exisOrder != null && !exisOrder.equals(order)){
            exisOrder.deletePayment(this);
        }
        order.addPayment(this);
        return true;
    }

    public void deleteOrder(){

        Order existOrder = this.order;
        this.order = null;
        if(existOrder != null){
            existOrder.deletePayment(this);
        }
    }

    abstract public void addAccount(Account account, int Percent);

    public void deleteAccount(Account account){
        if(account != null){
            if(accounts.contains(account)){
                if(accounts.size() > 1){
                    accounts.remove(account);
                    account.deletePayment(this);
                }
            }
        }
    }

}
