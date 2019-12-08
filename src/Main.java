import java.sql.SQLOutput;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Date openDate = new Date(2019, 12, 1);
        Account daniAccount = new Account("Dani", "Israel", openDate, null, 0);
        Account danaAccount = new PremiumAccount("Dana", "Israel", openDate, null, 0);
        Scanner sc = new Scanner(System.in);
        System.out.println("Login_id");
        String userName = sc.nextLine();
        System.out.println("Password:");
        String password = sc.nextLine();
        switch (userName){
            case "Dani":
                while (! password.equals("Dani123")){
                    System.out.println("Wrong password, please try again.");
                    password = sc.nextLine();
                }


                break;

            case "Dana":

                break;
        }

    }
}
