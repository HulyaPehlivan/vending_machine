package com.techelevator.Inventory;

public class Candy extends VendingMachineItems{
    public Candy(String slot, String name, double price, String type) {
        super(slot, name, price, type);
    }

    @Override
    public String getNoise() {
        return "Sugar Sugar, So Sweet!";
    }

    @Override
    public int itemDispensed() {
        return quantity--;

    }
}
