import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        init_dataBase();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Login_id: ");
        String userName = sc.nextLine();
        System.out.println("Enter Password: ");
        String password = sc.nextLine();
        String choice;
        boolean notExit=true;
        while (! SystemDatabase.Database.checkIfUserExist(userName, password)){
            System.out.println("Account does not exist. Would you like to create an account?");
            System.out.println("To create a new Account choose 1, to try again choose 2");
            choice = sc.nextLine();
            switch (choice){
                case "1":
                    String accountId = SystemDatabase.Database.addAccount(null, null, null, userName, password);
                    break;
                case "2":
                    System.out.println("Enter Login_id: ");
                    userName = sc.nextLine();
                    System.out.println("Enter Password: ");
                    password = sc.nextLine();
                    break;
            }
        }
        while (notExit) {
            System.out.println("What would you like to do?");
            System.out.println("To buy a product press 1");
            System.out.println("------------------------");
            System.out.println("To view your last order press 2");
            System.out.println("------------------------");
            System.out.println("To exit press 3");
            System.out.println("------------------------");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Please enter the product you'd like to buy: ");
                    String product = sc.nextLine();
                    if (SystemDatabase.Database.checkIfProductExist(product)) {
                        Product prod = SystemDatabase.Database.getProduct(product);
                        String accountId = SystemDatabase.Database.getId(userName);
                        Account account = SystemDatabase.Database.getAccount(accountId);
                        Order order = new Order(account.getBilling_Address(), account);
                        ShoppingCart shopCart = account.getShoppingCart();
                        LineItem lineItem = new LineItem(1, 10, prod, order, shopCart);
                        account.addOrder(order);
                        System.out.println("How would you like to pay?");
                        String pay = sc.nextLine();
                        int quantity;
                        int price;
                        switch (pay) {
                            case "immediate":
                                quantity = lineItem.getQuantity();
                                price = lineItem.getPrice();
                                ImmediatePayment imPayment = new ImmediatePayment(quantity * price, "details...", order, account);
                                imPayment.setPhoneConfirmation(true);
                                break;
                            case "delayed":
                                quantity = lineItem.getQuantity();
                                price = lineItem.getPrice();
                                DelayedPayment dePayment = new DelayedPayment(quantity * price, "details...", new Date(2020, 1, 1), order, account);
                                break;
                        }
                    }
                    break;
                case "2":
                    String accountId = SystemDatabase.Database.getId(userName);
                    Account account = SystemDatabase.Database.getAccount(accountId);
                    Order lastOrder = account.getLastOrder();
                    System.out.println(lastOrder);
                    break;

                case "3":
                    System.out.println("bye bye");
                    notExit=false;
                    break;
            }
        }
    }

    private static void init_dataBase() {
        Address daniAddress = new Address("Ben Gurion", 1, "Beer Sheva", "Israel", 123456);
        String daniId = SystemDatabase.Database.addAccount(daniAddress, "0545555555", "dani@post.bgu.ac.il", "Dani", "Dani123");
        Address danaAddress = new Address("Ben Gurion", 2, "Beer Sheva", "Israel", 123456);
        String danaId = SystemDatabase.Database.addPremiumAccount(danaAddress, "0546666666", "dana@post.bgu.ac.il", "Dana", "Dana123");
        SystemDatabase.Database.addSupplier("Osem");
        SystemDatabase.Database.addProduct("bmb123", "Bamba", "Osem");
        Product bamba = SystemDatabase.Database.getProduct("Bamba");
        bamba.setPremiumAccount(SystemDatabase.Database.getPremiumAccount(danaId));
    }
}

