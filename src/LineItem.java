public class LineItem {

    private int quantity;
    private int price;
    private Product product;
    private Order order;

    public LineItem(int quantity, int price, Product product, Order order) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.order = order;
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
}
