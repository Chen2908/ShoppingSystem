import java.util.ArrayList;

public class Supplier {

    private String id;
    private String name;
    private ArrayList<Product> products;

    public Supplier(String id, String name) {
        this.id = id;
        this.name = name;
        products = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int NumberOfProducts(){
        return products.size();
    }

    public boolean addProduct (Product aProduct){
        if(aProduct == null){
            return false;
        }
        if(products.contains(aProduct)){
            return false;
        }
        if(this.equals(aProduct.getSupplier())){
            products.add(aProduct);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteProduct(Product aProduct){
        if(aProduct == null){
            return false;
        }
        if(products.contains(aProduct) && !this.equals(aProduct.getSupplier())){
            products.remove(aProduct);
            return true;
        }
        else{
            return false;
        }
    }

    public void deleteSupplier (){
        for( Product product : products){
            product.deleteProduct();
        }
    }



}
