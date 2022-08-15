package com.techelevator.Inventory;

public class Drink extends VendingMachineItems{
    public Drink(String slot, String name, double price, String type) {
        super(slot, name, price, type);
    }

    @Override
    public String getNoise() {
        return "Drinky Drinky, Slurp Slurp!";
    }

    @Override
    public int itemDispensed() {
        return quantity--;
    }
}
