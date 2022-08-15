package com.techelevator.Inventory;

public class Munchy extends VendingMachineItems{

    public Munchy(String slot, String name, double price, String type) {
        super(slot, name, price, type);
    }

    @Override
    public String getNoise() {
        return "Munchy Muchy, So Good!";
    }

    @Override
    public int itemDispensed() {
       return super.itemDispensed();
    }
}
