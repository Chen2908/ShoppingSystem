import java.util.ArrayList;

public class Product {

    private String id;
    private String name;
    private Supplier supplier;
    private ArrayList<LineItem> lLineItems;
    private PremiumAccount premiumAccount;

    //constructor without premiumAccount
    public Product(String id, String name, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        lLineItems = new ArrayList<>();
        premiumAccount = null;
    }

    //constructor with premiumAccount
    public Product(String id, String name, Supplier supplier, PremiumAccount premiumAccount) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        lLineItems = new ArrayList<>();
        premiumAccount = premiumAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public boolean addLineItem(LineItem lineItem){
        if(lineItem == null){
            return false;
        }
        if(lLineItems.contains(lineItem)){
            return false;
        }
        else if(this.equals(lineItem.getProduct())){
            lLineItems.add(lineItem);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean removeLineItem(LineItem lineItem){
        if(lineItem == null){
            return false;
        }
        if(lLineItems.contains(lineItem) && this.equals(lineItem.getProduct())){
            lLineItems.remove(lineItem);
            return true;
        }
        else{
            return false;
        }
    }

    public PremiumAccount getPremiumAccount() {
        return premiumAccount;
    }

    public void setPremiumAccount(PremiumAccount premiumAccount) {
        this.premiumAccount = premiumAccount;
    }

    public boolean deleteProduct(){
        Supplier productSupplier = supplier;
        this.supplier = null;
        if(productSupplier != null){
            productSupplier.deleteProduct(this);
        }
        for(LineItem lineItem : lLineItems){
            lineItem.deleteLineItem();
        }
        return false;
    }



}
