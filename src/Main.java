import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        init_dataBase();
        Scanner sc = new Scanner(System.in);
        System.out.println("Login_id");
        String userName = sc.nextLine();
        System.out.println("Password:");
        String password = sc.nextLine();
        String choice;
        switch (userName){
            case "Dani":
                while (! password.equals("Dani123")){
                    System.out.println("Wrong password, please try again.");
                    password = sc.nextLine();
                }
                System.out.println("What would you like to do?");
                System.out.println("To buy a product press 1");
                System.out.println("To view your last order press 2");
                choice = sc.nextLine();
                switch (choice){
                    case "1":
                        System.out.println("Please enter the product you'd like to buy:");
                        String product = sc.nextLine();
                        if (SystemDatabase.Database.checkIfProductExist(product)) {
                            Product bamba = SystemDatabase.Database.getProduct(product);
                            Account daniAccount = SystemDatabase.Database.getAccount("Dani");
                            Order daniOrder= new Order(daniAccount.getBilling_Address(), daniAccount);
//                            LineItem lineItem = new LineItem(1, 5, bamba);
//
//                            daniAccount.addOrder()
                        }

                        break;
                }



                break;

            case "Dana":
                while (! password.equals("Dana123")){
                    System.out.println("Wrong password, please try again.");
                    password = sc.nextLine();
                }
                break;
        }

    }

    private static void init_dataBase() {
        Address daniAddress = new Address( "Ben Gurion",1,"Beer Sheva", "Israel", 123456);
        String daniId = SystemDatabase.Database.addAccount(daniAddress, "0545555555", "dani@post.bgu.ac.il", "Dani", "Dani123");
        Address danaAddress = new Address( "Ben Gurion",2,"Beer Sheva", "Israel", 123456);
        String danaId= SystemDatabase.Database.addPremiumAccount(danaAddress, "0546666666", "dana@post.bgu.ac.il", "Dana", "Dana123");
        SystemDatabase.Database.addSupplier("Osem");
        String OsemId= SystemDatabase.Database.getSupplier("Osem").getId();
        SystemDatabase.Database.addProduct("bmb123", "Bamba", OsemId);
        Product bamba = SystemDatabase.Database.getProduct("Bamba");
        bamba.setPremiumAccount(SystemDatabase.Database.getPremiumAccount(danaId));
    }
}
