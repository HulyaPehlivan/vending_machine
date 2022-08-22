package com.techelevator.ui;

import com.techelevator.Inventory.VendingMachineItems;
import com.techelevator.reader.VendingMachineBuilder;
import com.techelevator.transaction.UserMoney;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 *
 * Dependencies: None
 */
public class UserInput {
    private Scanner scanner = new Scanner(System.in);

    public String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println("D) Display Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");
        System.out.println("+++++++++++++++++++++++++++++");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        System.out.println("option = " + option);
        System.out.println("  ");
        System.out.println("  ");


        if (option.equals("d")) {
            return "display";
        } else if (option.equals("p")) {
            return "purchase";
        } else if (option.equals("e")) {
            return "exit";
        } else {
            return "";
        }
    }

public String getInputFromUser(String message){
    System.out.println(message);
    String userAnswer = scanner.nextLine();
    return userAnswer;
}

    public String getPurchaseScreenOptions(BigDecimal currentMoney) {
        System.out.println("###########################");
        System.out.println("(M) Feed Money");
        System.out.println("(S) Select an Item");
        System.out.println("(F) Finish Transaction");
        System.out.println("###########################");
        System.out.println();
        System.out.println("Current Money Provided: " + (currentMoney));
        System.out.println();
        System.out.println("Please select an option?");
        System.out.println("###########################");
        String purchaseOption = scanner.nextLine();
        System.out.println();

       String optionForPurchase = purchaseOption.trim().toLowerCase();
        System.out.println("option = " + optionForPurchase);
        System.out.println("  ");
        System.out.println("  ");

        if (optionForPurchase.equals("m")) {
            return "Feed Money";
        }else if(optionForPurchase.equals("s")){
        return "Select Item";
        }else if (optionForPurchase.equals("f")){
            return "Finish Transaction";
        }
        return purchaseOption;
    }



}