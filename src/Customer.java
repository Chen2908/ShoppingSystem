public class Customer {
    private String id;
    private Address address;
    private String phone;
    private String email;
    private WebUser webUser;
    private Account account;

    public Customer(Address address, String phone, String email, Account account){
        this.id = account.getId();
        this.account = account;
        webUser = null;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Customer(Address address, String phone, String email, ShoppingCart shoppingCart){
        this.account = new Account(this, shoppingCart);
        this.id = account.getId();
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public WebUser getWebUser() {
        return webUser;
    }

    public boolean hasWebUser() {
        if (this.webUser == null)
            return false;
        return true;

    }

    public boolean setWebUser(WebUser newWebUser){
        //assumes that cannot set a null webuser
        if (newWebUser== null) {
            newWebUser = null;
            return false;
        }
        //unable to set the new webuser
        if (webUser!=null && !webUser.equals(newWebUser) && equals(webUser.getCustomer())){
            return false;
        }
        Customer me= newWebUser.getCustomer();
        if (!this.equals(me)){
            return false;
        }else{
            this.webUser = newWebUser;
            return true;
        }
    }

    public void removeWebUser(){
        WebUser existingWebUser = webUser;
        webUser=null;
        if (existingWebUser!=null){
            existingWebUser.deleteWebUser();
        }
    }

    public void deleteCustomer (){
        if(hasWebUser()){
            WebUser _webUser = this.webUser;
            this.webUser = null;
            _webUser.deleteWebUser();
        }
    }

    public void deleteAccount() {
        Account existAccount = this.account;
        existAccount.deleteShoppingCart();
        for(int i=0;i<existAccount.orders.size();i++){
            existAccount.deleteOrder(existAccount.orders.get(i));
        }
        account = null;
        if(existAccount != null){
            existAccount.deleteCustomer();
        }
    }
}
