package com.techelevator;


import com.techelevator.application.VendingMachine;
import com.techelevator.reader.VendingMachineBuilder;
import com.techelevator.transaction.VendingMachineMoney;

public class VendingMachineCLI {

	public static void main(String[] args) {
VendingMachineBuilder vendingMachineBuilder = new VendingMachineBuilder();
//		VendingMachineMoney vendingMachineMoney = new VendingMachineMoney();
		VendingMachine vendingMachine = new VendingMachine(vendingMachineBuilder);
		vendingMachine.run();
	}
}
