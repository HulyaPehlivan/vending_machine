package com.techelevator.transaction;

import com.techelevator.ui.UserInput;

public class VendingMachineMoney {
    // add var
    private double balance = 0;
    private double depositAmount ;



    public double feedMoney(double depositAmount){
     balance = (balance + depositAmount);
        return balance;
    }
    public double withdrawPurchase(double withdrawAmount){
        balance = (balance - withdrawAmount);
        return balance;
    }
    public double getDepositAmount() {
        return depositAmount;
    }
    public double getBalance() {
        return this.balance = balance;
    }

    public void setBalance(double balance) {
        this.balance = balance ;
    }

 public static void moneyExchange(){
        double nickel = 0.05;
        double dime = 0.10;
        double quarter = 0.25;
        double dollar = 1.00;
 }



}
