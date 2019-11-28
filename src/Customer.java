public class Customer {


    private String id;
    private Address address;
    private String phone;
    private String email;

    public Customer(String id, Address address, String phone, String email) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
