public class LineItem {

    private int quantity;
    private int price;
    private Product product;
    private Order order;
    private ShoppingCart shoppingCart;


    public LineItem(int quantity, int price, Product product, Order order, ShoppingCart shoppingCart) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.order = order;
        this.shoppingCart = shoppingCart;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product getProduct(){
        return product;
    }

    public Order getOrder(){
        return order;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    public void deleteLineItem(){
        Product product = this.product;
        if(product != null){
            product.removeLineItem(this);
        }
        this.shoppingCart = null;
        Order _order = this.order;
        this.order = null;
        if(_order != null){
            _order.removeLineItem(this); 
        }
    }


}
