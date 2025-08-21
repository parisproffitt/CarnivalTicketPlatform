/**
 * My program functions to simulate a carnival's ticket purchasing platform
 *
 * @author Paris Proffitt
 * @version October 7th, 2024
*/

import java.util.Scanner;

public class CarnivalTicketREDONE {
   public static void printTicket(String fullName, String id, double price) {
       System.out.println();
       System.out.println("============================================");
       System.out.println("Welcome to the APCS Carnival, " + fullName + "!");
       System.out.println("Your user ID is " + id);
       System.out.println("The cost of your ticket is $" + price + ".");
       System.out.println("Have a great time at the APCS Carnival today!");
       System.out.println("============================================");
   }

   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

       //User Input
       System.out.print("Enter your full name (First Last): ");
       String fullName = input.nextLine();
       System.out.print("Enter your age: ");
       int age = input.nextInt();
       input.nextLine();  
       
       //Questions
       System.out.print("Are you a first responder? (yes/no): ");
       String isFirstResponder = input.nextLine();
       System.out.print("Are you a veteran? (yes/no): ");
       String isVeteran = input.nextLine();

       //Determining Price
       double ticketPrice;
       if (age > 18) {
           ticketPrice = 12;
       } else if (age >= 6) {
           ticketPrice = 11;
       } else if (age >= 3) {
           ticketPrice = 9;
       } else {
           ticketPrice = 2;
       }

       //Discount
       if (((isFirstResponder.equals("yes")) || (isVeteran.equals("yes"))) && (age > 18)) {
           ticketPrice *= 0.5;
       }

       //Generate User ID
       String userID = generateUserID(fullName);
       
       //Print Ticket
       printTicket(fullName, userID, ticketPrice);
    }
    
    public static String generateUserID(String fullName) {
       int spaceIndex = fullName.indexOf(' ');
       
       String firstInitial = fullName.substring(0, 1);
       String lastName = fullName.substring(spaceIndex + 1);
       int randomNumber = (int)(Math.random() * 1000 +1);
       
       return firstInitial + lastName + randomNumber;   
   }
}