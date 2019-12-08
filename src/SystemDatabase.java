import java.util.ArrayList;
import java.util.Date;

public class SystemDatabase {

    public static class Database {
        private static ArrayList<Account> accounts= new ArrayList<>();
        private static ArrayList<Customer> customers= new ArrayList<>();
        private static ArrayList<Product> products= new ArrayList<>();
        private static ArrayList<Supplier> suppliers=new ArrayList<>();


        public static void addAccount(String id, String billing_Address, Date open, Date close, int balance) {
            Account account = new Account(id, billing_Address, open, close, balance);
            accounts.add(account);
        }

        public static void addPremiumAccount(String id, String billing_Address, Date open, Date close, int balance) {
            Account account = new PremiumAccount(id, billing_Address, open, close, balance);
            accounts.add(account);
        }

        public static void addCustomer(String id, Address address, String phone, String email) {
            Customer customer = new Customer(id, address, phone, email);
            customers.add(customer);
        }

        public static void addProduct(String id, String name, String supplierId) {
            Product product = new Product(id, name, getSupplier(supplierId));
            products.add(product);
        }

        public static void addSupplier(String id, String name) {
            Supplier supplier = new Supplier(id, name);
            suppliers.add(supplier);
        }

        public static Supplier getSupplier(String id){
            for (Supplier supp: suppliers){
                if (supp.getId().equals(id))
                    return supp;
            }
            return null;
        }

        public static boolean checkIfProductExist(String productName){
            for (Product pro: products){
                if (pro.getName().equals(productName))
                    return true;
            }
            return false;
        }

        public static Account getAccount(String id){
            for (Account account: accounts){
                if (account.getId().equals(id))
                    return account;
            }
            return null;
        }

        public static Product getProduct(String product) {
            for (Product pro: products){
                if (pro.getName().equals(product))
                    return pro;
            }
            return null;
        }
    }

}
