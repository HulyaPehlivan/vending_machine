package com.techelevator.Inventory;

public class Gum extends VendingMachineItems{
    public Gum(String slot, String name, double price, String type) {
        super(slot, name, price, type);
    }

    @Override
    public String getNoise() {
        return "Chewy Chewy, lots O Bubbles!";
    }

    @Override
    public int itemDispensed() {
        return quantity--;
    }
}
