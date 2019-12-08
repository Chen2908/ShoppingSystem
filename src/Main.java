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
                            Account daniAccount = SystemDatabase.Database.getAccount("Dani");

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
        Date openDate = new Date(2019, 12, 1);
        SystemDatabase.Database.addAccount("Dani", "Israel", openDate, null, 0);
        SystemDatabase.Database.addPremiumAccount("Dana", "Israel", openDate, null, 0);
        SystemDatabase.Database.addSupplier("123456", "Dana");
        SystemDatabase.Database.addProduct("bmb123", "Bamba", "123456");
    }
}
