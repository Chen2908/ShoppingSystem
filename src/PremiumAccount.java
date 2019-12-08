import java.util.ArrayList;
import java.util.Date;

public class PremiumAccount extends Account {

    private ArrayList<Product> lProducts;
    public PremiumAccount(String id, String billingAddress, Date open, Date close, int balance) {
        super(id, billingAddress, open, close, balance);
        lProducts = new ArrayList<>();
    }

    public ArrayList<Product> getlProducts() {
        return lProducts;
    }

    public void setlProducts(ArrayList<Product> lProducts) {
        this.lProducts = lProducts;
    }

    public boolean addProduct (Product product){
        if(lProducts.contains(product) || product == null){
            return false;
        }
        PremiumAccount _premiumAccout = product.getPremiumAccount();
        if(_premiumAccout == null){
            product.setPremiumAccount(this);
            return false;
        }
        else if(!this.equals(_premiumAccout)){
            _premiumAccout.removeProduct(product);
            lProducts.add(product);
            return true;
        }
        else{
            lProducts.add(product);
            return true;
        }
    }

    private void removeProduct(Product product) {
        if (lProducts.contains(product)) {
            product.setPremiumAccount(null);
        }
    }
}
