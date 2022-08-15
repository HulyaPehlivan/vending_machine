package com.techelevator.application;

import com.techelevator.Inventory.Candy;
import com.techelevator.Inventory.VendingMachineItems;
import com.techelevator.reader.VendingMachineBuilder;

import com.techelevator.transaction.VendingMachineMoney;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    //purchase item method
    public void purchaseItem(){
        while(true){
            String choice2 = userInput.getPurchaseScreenOptions(vendingMachineMoney.getBalance());
            if (choice2.equals("Feed Money")) {

                String getMoneyFromUser = userInput.getInputFromUser("Please enter dollar amount: 1, 5, 10 or 20");
                double getMoneyFromUserDouble = Double.parseDouble(getMoneyFromUser);
                vendingMachineMoney.feedMoney(getMoneyFromUserDouble);
                System.out.println("test current balance " + vendingMachineMoney.getBalance());
                choice2 = userInput.getPurchaseScreenOptions(getMoneyFromUserDouble);
//do we need something else?


            } if (choice2.equals("Select Item")) {
                //call purchase item.purchaseitem()
                UserOutput.displayInventoryItems(inventory);
                String slotNumberFromUser = userInput.getInputFromUser("Please enter the slot number: ");
                if (!inventory.containsKey(slotNumberFromUser)) {
                    String validSlotNumberFromUser = userInput.getInputFromUser("Please Enter a Valid Slot Number");
                } else if (inventory.get(slotNumberFromUser).getQuantity() > 0) {//check quantity
                    userOutput.displayMessage("You want to buy " + inventory.get(slotNumberFromUser).getName() + " " + inventory.get(slotNumberFromUser).getPrice());
                    double itemPrice = inventory.get(slotNumberFromUser).getPrice();
                    double leftMoney = vendingMachineMoney.withdrawPurchase(itemPrice);
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

                    if (leftMoney > 0) {
                        userOutput.displayMessage("You have " + leftMoney + " remaining.");
                    } else if (leftMoney<0){
                        userOutput.displayMessage("Not enough money!");
                    }
                } else {
                    double changeAmount = vendingMachineMoney.getBalance();
                    userOutput.displayMessage("Your change is: " + changeAmount);
                    //end transaction. give change. 0 out vending machine money
                }
            }

        }

    }
    public void exit(){

    }

    VendingMachineMoney vendingMachineMoney = new VendingMachineMoney();
    private Map<String, VendingMachineItems> inventory = new HashMap<>();

    public VendingMachine(VendingMachineBuilder vendingMachineBuilder) {
        inventory = vendingMachineBuilder.getInventory();
    }

    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();


    public void run() {
        while (true) {
            userOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            System.out.println(choice);

            if (choice.equals("display")) {
                // display the items
                UserOutput.displayInventoryItems(inventory);
            } else if (choice.equals("purchase")) {
                // make a purchase
                purchaseItem();
            } else if (choice.equals("exit")) {
                // good bye
                exit();
                break;
            } else {

            }
        }


    }



}

