import java.util.Date;

public class ShoppingCart {

    private Date created;
    private WebUser webUser;

    public ShoppingCart(Date created, WebUser webUser) {
        this.created = created;
        this.webUser=webUser;
    }

    private void setWebUser(WebUser webUser) {
        if (webUser==null){

        }
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
