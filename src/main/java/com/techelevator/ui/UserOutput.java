package com.techelevator.ui;

import com.techelevator.Inventory.VendingMachineItems;

import java.util.Map;

public class UserOutput {
    public void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayInventoryItems(Map<String, VendingMachineItems> inventory) {

        for (Map.Entry<String, VendingMachineItems> itemEntry : inventory.entrySet()) {
            System.out.println(itemEntry.getValue().getSlot() + " " + itemEntry.getValue().getName() + " : " + itemEntry.getValue().getPrice() +" : "+itemEntry.getValue().quantity);
        }

    }
}