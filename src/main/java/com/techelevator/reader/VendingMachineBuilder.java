package com.techelevator.reader;

import com.techelevator.Inventory.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineBuilder {

    public Map<String, VendingMachineItems> getInventory(){

        File file = new File ("catering.csv");

        Map<String, VendingMachineItems> inventory = new HashMap<>();

        try(Scanner fileScanner = new Scanner(file)) {
            while(fileScanner.hasNextLine()){
                String[] itemProperties = fileScanner.nextLine().split("\\,");
                System.out.println(itemProperties);
                VendingMachineItems item;
                if (itemProperties[3].equals("Gum")){
                    item = new Gum(itemProperties[0],itemProperties[1],Double.parseDouble(itemProperties[2]),itemProperties[3]);

                }  else if (itemProperties[3].equals("Drink")){
                    item = new Drink(itemProperties[0],itemProperties[1],Double.parseDouble(itemProperties[2]),itemProperties[3]);
                }else if (itemProperties[3].equals("Munchy")){
                    item = new Munchy(itemProperties[0],itemProperties[1],Double.parseDouble(itemProperties[2]),itemProperties[3]);}

                else item = new Candy(itemProperties[0],itemProperties[1],Double.parseDouble(itemProperties[2]),itemProperties[3]);

                item.setName(itemProperties[1]);
                item.setSlot(itemProperties[0]);
                item.setPrice(Double.parseDouble(itemProperties[2]));
                inventory.put(itemProperties[0],item);
            }
        } catch (FileNotFoundException e) {
            System.out.println("NO LONGER AVAILABLE");}
        return inventory;
    }
}
