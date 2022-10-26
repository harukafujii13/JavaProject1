import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// import javax.sound.sampled.SourceDataLine;

public class MyPage {
    private String userName;
    private String userPassword;
    private int price;

    List<String> plan = new ArrayList<String>();

    // new MyPage()

    // public MyPage(){

    // }

    // new MyPage("Haruka", "12345", 700)

    public MyPage(String userName, String userPassword, int price) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.price = price;
    }


    // MyPage ba = new MyPage("Haruka", "12345", 700)
    // ba.getUserName()

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    void specialOffer(char choice){
        switch (choice) {
            case 'a':
                if (plan.contains("Meal service")) {
                    System.out.println("You've already applied this offer. Please confirm your booking information.");
                } else {
                    System.out.println("You've applied the additional offer successfully.\nPlease confirm your booking price on the top page.");
                    price = price + 13;
                    plan.add("Meal service");
                }

                break;
            
            case 'b':
                if (plan.contains("Access to Lounges")) {
                    System.out.println("You've already applied this offer. Please confirm your booking information.");
                } else {
                    System.out.println("You've applied the additional offer successfully.\nPlease confirm your booking price on the top page.");
                    price = price + 50;
                    plan.add("Access to Lounges");
                }
                
                break;

            case 'c':
                if(plan.contains("Refundability")) {
                    System.out.println("You've already applied this offer. Please confirm your booking information.");
                } else {
                    System.out.println("You've applied the additional offer successfully.\nPlease confirm your booking price on the top page.");
                    price = price + 90;
                    plan.add("Refundability");
                }

                break;

                default:
                System.out.println("Invalid offer. Please try again.\n");
                break;
            


        

        }

    }

    void showMenue() {
        char option;
        Scanner scanner = new Scanner(System.in);


        do{
            System.out.println("--------------------");
            System.out.println("My page | FUJII Air");
            System.out.println("--------------------");
            System.out.println("A: Confirm your booking information");
            System.out.println("B: Get special offers");
            System.out.println("C: Cancel your booking");
            System.out.println("D: Quit");
            option = scanner.next().charAt(0);

            AirlineReservation.clearConsole();

            switch (option) {
                case 'a':
                    System.out.println("\n---Your booking information---");
             
                    System.out.println("Total price: $" + price);
                    break;

                case 'b':
                    if (price < 1) {
                        System.out.println("You don't have any booking.\n Please book tickets first.\n");   
                    } else {
                        System.out.println("-----------------------------");
                        System.out.println("Get special offers");
                        System.out.println("-----------------------------");
                        System.out.println("A: Meal service + $13");
                        System.out.println("B: Access to Lounges + $50");
                        System.out.println("C: Refundability + $90");
                        System.out.println("-----------------------------");

                        char addplan;
                        addplan = scanner.next().charAt(0);
                        
                        specialOffer(addplan);

                        break;
                    }


                case 'c':
                    System.out.println("Are you sure you want to cancel this travel? Type [yes/no]\n");

                    String answer = scanner.next();
                    if (answer.equals("yes")) {
                        System.out.println("Your booking is canceled successfully.");
                        System.out.println("Please confirm your price from the My page.\n");
                        price = 0;
                        plan.clear();

                    } else if (answer.equals("no")) {
                        System.out.println("You'll go back to the Mypage.\n");
                    } else {
                        System.out.println("Invalid typing. Please try again. ");
                    }

                    break;

                }
                    

        }while (Character.toLowerCase(option) != 'd');

        System.out.println("Thank you for visiting us.\nHave a nice trip!\n\n");
        scanner.close();
    } 

    
    
    

}
