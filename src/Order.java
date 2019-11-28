import java.util.Date;

enum OrderStatus{
    NEW, HOLD, SHIPPED, DELIVERED, CLOSED;
}

public class Order {

    private String name;
    private Date ordered;
    private Date shipped;
    private Address ship_to;
    private OrderStatus status;
    private float total;

    public Order(String name, Date ordered, Date shipped, Address ship_to, float total) {
        this.name = name;
        this.ordered = ordered;
        this.shipped = shipped;
        this.ship_to = ship_to;
        this.total = total;
        this.status=OrderStatus.NEW;
    }

    public String getName() {
        return name;
    }

    public Date getOrdered() {
        return ordered;
    }

    public Date getShipped() {
        return shipped;
    }

    public Address getShip_to() {
        return ship_to;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public float getTotal() {
        return total;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrdered(Date ordered) {
        this.ordered = ordered;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    public void setShip_to(Address ship_to) {
        this.ship_to = ship_to;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
