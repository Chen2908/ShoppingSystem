import java.util.ArrayList;
import java.util.Date;

public class ShoppingCart {

    private Date created;
    private WebUser webUser;
    private ArrayList<LineItem> lLineItems;

    public ShoppingCart(WebUser webUser) {
        this.created = new Date();
        this.webUser=webUser;
        this.lLineItems = new ArrayList<>();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean addLineItem(LineItem lineItem){
        if(lineItem == null || lLineItems.contains(lineItem)){
            return false;
        }
        else if(this.equals(lineItem.getShoppingCart())){
            lLineItems.add(lineItem);
            return true;
        }
        else{
            lineItem.setShoppingCart(this);
            lLineItems.add(lineItem);
            return true;
        }
    }

    public void deleteShoppingCart (){
        for (LineItem lineItem : lLineItems){
            lineItem.deleteLineItem();
        }
        WebUser _webUser = this.webUser;
        this.webUser = null;
        if(_webUser != null){
            _webUser.deleteWebUser();
        }
    }

    public WebUser getWebUser() {
        return webUser;
    }

    public ArrayList<LineItem> getlLineItems() {
        return lLineItems;
    }

    public void setlLineItems(ArrayList<LineItem> lLineItems) {
        this.lLineItems = lLineItems;
    }

    public void setWebUser(WebUser webUser) {
        if (webUser==null){

        }
    }



}
