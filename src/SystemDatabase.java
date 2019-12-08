import java.util.ArrayList;
import java.util.Date;

public class SystemDatabase {

    public static class Database {
        private static ArrayList<Account> accounts= new ArrayList<>();
        private static ArrayList<PremiumAccount> premiumAccounts= new ArrayList<>();
        private static ArrayList<Customer> customers= new ArrayList<>();
        private static ArrayList<Product> products= new ArrayList<>();
        private static ArrayList<Supplier> suppliers=new ArrayList<>();
        private static ArrayList<WebUser> webUsers=new ArrayList<>();




        public static String addAccount(Address address, String phone, String email, String loginId, String password){
            WebUser webUser = new WebUser(loginId, password);
            Account account = new Account(address, phone, email, webUser);
            webUser.setCustomer(account.getCustomer());
            webUsers.add(webUser);
            accounts.add(account);
            customers.add(account.getCustomer());
            return account.getId();
        }

        public static String addPremiumAccount(Address address, String phone, String email, String loginId, String password){
            WebUser webUser = new WebUser(loginId, password);
            PremiumAccount account = new PremiumAccount(address, phone, email, webUser);
            webUser.setCustomer(account.getCustomer());
            premiumAccounts.add(account);
            customers.add(account.getCustomer());
            return account.getId();
        }

        public static void addProduct(String id, String name, String supplierId) {
            Product product = new Product(id, name, getSupplier(supplierId));
            products.add(product);
        }

        public static void addSupplier(String name) {
            Supplier supplier = new Supplier(name);
            suppliers.add(supplier);
        }

        public static Supplier getSupplier(String name){
            for (Supplier supp: suppliers){
                if (supp.getName().equals(name))
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

        public static PremiumAccount getPremiumAccount(String id){
            for (PremiumAccount account: premiumAccounts){
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
