package com.techelevator.transaction;

import java.math.BigDecimal;

public class UserMoney {
    // add properties
    private BigDecimal userBalance = new BigDecimal("0.00");
    private BigDecimal currentMoney;
    private BigDecimal itemPrice ;

    //default constructor
    public UserMoney() {
    }

    public void setUserBalance(BigDecimal userBalance) {
        this.userBalance = userBalance;
    }

    public BigDecimal getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(BigDecimal currentMoney) {
        this.currentMoney = currentMoney;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public BigDecimal getUserBalance(){
        return userBalance ;
    }
    public BigDecimal getWithdrawAmount(BigDecimal itemPrice){
        BigDecimal withdrawAmount = new BigDecimal(String.valueOf(itemPrice));
        return this.userBalance = userBalance.subtract(withdrawAmount);
    }



    public BigDecimal currentMoney() {
        BigDecimal currentMoney = new BigDecimal(String.valueOf(userBalance));
        return this.userBalance = userBalance.add(currentMoney);
    }
}
