import java.util.ArrayList;

public class Product {

    private String id;
    private String name;
    private Supplier supplier;
    private ArrayList<LineItem> lineItems;

    public Product(String id, String name, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        lineItems = new ArrayList<>();
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
        if(lineItems.contains(lineItem)){
            return false;
        }
        else if(this.equals(lineItem.getProduct())){
            lineItems.add(lineItem);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteLineItem(LineItem lineItem){
        if(lineItem == null){
            return false;
        }
        if(lineItems.contains(lineItem)){
            lineItems.remove(lineItem);
            return true;
        }
        else{
            return false;
        }
    }


}
