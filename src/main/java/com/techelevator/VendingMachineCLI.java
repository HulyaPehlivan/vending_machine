package com.techelevator;


import com.techelevator.application.VendingMachine;
import com.techelevator.reader.VendingMachineBuilder;

public class VendingMachineCLI {

	public static void main(String[] args) {
		VendingMachineBuilder vendingMachineBuilder = new VendingMachineBuilder();
		VendingMachine vendingMachine = new VendingMachine(vendingMachineBuilder);
		vendingMachine.run();
	}
}
