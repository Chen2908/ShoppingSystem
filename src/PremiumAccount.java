import java.util.ArrayList;
import java.util.Date;

public class PremiumAccount extends Account {

    private ArrayList<Product> lProducts;

    public PremiumAccount(Address address, String phone, String email, WebUser webuser) {
        super(address, phone, email, webuser);
        lProducts = new ArrayList<>();
    }

    public PremiumAccount(Customer customer, ShoppingCart shoppingCart) {
        super(customer, shoppingCart);
        lProducts = new ArrayList<>();
    }

    public ArrayList<Product> getlProducts() {
        return lProducts;
    }

    public void setProducts(ArrayList<Product> lProducts) {
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

    public void removeProduct(Product product) {
        if (lProducts.contains(product)) {
            product.setPremiumAccount(null);
        }
    }

    public void deletePremiumAccount(){
        for(Product product : lProducts){
            product.setPremiumAccount(null);
        }
    }

}
