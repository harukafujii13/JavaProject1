import java.io.IOException;
import java.util.Scanner;

public class AirlineReservation {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        MyPage account = new MyPage("Haruka", "12345", 700);

            clearConsole();
            System.out.println("*================================*");
            System.out.println("    Welsome to FUJII Airlines!");
            System.out.println("    This is your login page.");
            System.out.println("*================================*");


        while(true) {
            System.out.println("    Please enter your username.");

            String user = input.nextLine();
            System.out.println("    Please enter your password.");
            String pass = input.nextLine();

            if(user.equals(account.getUserName()) && pass.equals(account.getUserPassword())){
                System.out.println("\n Welcome " + account.getUserName() + "!" + "\n Confirm your flight booking.");
                break;

            }

            System.out.println(
                "Invalid credentials\n\n" +
                "Press [enter] key to try again or pass [Q] to exit\n\n"
            );
            if(input.nextLine().toLowerCase().equals("q")){
                System.out.println("Have a nice trip!!");
            }
        }
        clearConsole();
        account.showMenue();
        input.close();
    }

    public static void clearConsole(){
        {
            try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
                    System.out.println("\003\143");
        } catch (IOException | InterruptedException ex) {}
    }
}}