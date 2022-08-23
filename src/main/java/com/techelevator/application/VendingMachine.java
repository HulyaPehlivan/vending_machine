package com.techelevator.application;


import com.techelevator.Inventory.VendingMachineItems;
import com.techelevator.reader.VendingMachineBuilder;
import com.techelevator.transaction.UserMoney;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    UserMoney userMoney = new UserMoney();
    //first menu for selection


    public void run() {
        String menuSelection = "";
        try {
            while (true) {
                userOutput.displayHomeScreen();
                menuSelection = userInput.getHomeScreenOption();

                if (menuSelection.equals("display")) {
                    // display the items
                    UserOutput.displayInventoryItems(inventory);
                } else if (menuSelection.equals("purchase")) {
                    // make a purchase
                    purchaseItem();
                } else if (menuSelection.equals("exit")) {
                    // goodbye
                    System.exit(0);
                    break;
                } else {
                    System.out.println("Invalid Selection");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void purchaseItem(){

        while(true){
            String purchaseScreenOptions = userInput.getPurchaseScreenOptions(userMoney.getMoneyHeld());

            if (purchaseScreenOptions.equals("Feed Money")) {
                userMoney.getMoneyHeld();
                String getMoneyFromUser = userInput.getInputFromUser("Please enter dollar amount: 1, 5, 10 or 20$");
             //add balance
                BigDecimal balance = userMoney.addMoney(BigDecimal.valueOf(Long.parseLong(getMoneyFromUser)));
                System.out.println("Your current balance " + balance);
                purchaseScreenOptions = userInput.getPurchaseScreenOptions(userMoney.getMoneyHeld());


            } if (purchaseScreenOptions.equals("Select Item")) {
                //call purchase item.purchaseItem()
                UserOutput.displayInventoryItems(inventory);
                String slotNumberFromUser = userInput.getInputFromUser("Please enter the slot number: ");
                if (!inventory.containsKey(slotNumberFromUser)) {
                    String validSlotNumberFromUser = userInput.getInputFromUser("Please Enter a Valid Slot Number");
                } else if (inventory.get(slotNumberFromUser).getQuantity() > 0) {//check quantity
                    userOutput.displayMessage("You want to buy " + inventory.get(slotNumberFromUser).getName() + " " + inventory.get(slotNumberFromUser).getPrice());
                   BigDecimal itemPrice = BigDecimal.valueOf(inventory.get(slotNumberFromUser).getPrice());
                    BigDecimal leftMoney = userMoney.subtractMoney(itemPrice);
                    if (inventory.get(slotNumberFromUser).getType().equals("Candy")){
                        inventory.get(slotNumberFromUser).itemDispensed();
                        userOutput.displayMessage(inventory.get(slotNumberFromUser).getNoise());
                    } else if (inventory.get(slotNumberFromUser).getType().equals("Drink")){
                        inventory.get(slotNumberFromUser).itemDispensed();
                       userOutput.displayMessage(inventory.get(slotNumberFromUser).getNoise());
                    } else if (inventory.get(slotNumberFromUser).getType().equals("Munchy")){
                        inventory.get(slotNumberFromUser).itemDispensed();
                        userOutput.displayMessage(inventory.get(slotNumberFromUser).getNoise());
                    } else if (inventory.get(slotNumberFromUser).getType().equals("Gum")){
                        inventory.get(slotNumberFromUser).itemDispensed();
                        userOutput.displayMessage(inventory.get(slotNumberFromUser).getNoise());
                    } else userOutput.displayMessage("That is not a valid item");

                    if (leftMoney.doubleValue() > 0) {
                        userOutput.displayMessage("You have " + leftMoney + " remaining.");
                    } else if (leftMoney.doubleValue() < 0){
                        userOutput.displayMessage("Not enough money!");
                    }
                } else {
                   BigDecimal changeAmount = userMoney.getMoneyHeld();
                    userOutput.displayMessage("Your change is: " + changeAmount);
                    //end transaction. give change. 0 out vending machine money
                }
            }if (purchaseScreenOptions.equals("Finish Transaction")) {
              finishTransaction();
              System.exit(0);
            }

        }

    }

    public void exit(){}

    private Map<String, VendingMachineItems> inventory = new HashMap<>();

    public VendingMachine(VendingMachineBuilder vendingMachineBuilder) {
        inventory = vendingMachineBuilder.getInventory();
    }

    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();


    public boolean finishTransaction() {
        BigDecimal temp = userMoney.getMoneyHeld();
        userMoney.makeChange();
        return false;
    }


}

