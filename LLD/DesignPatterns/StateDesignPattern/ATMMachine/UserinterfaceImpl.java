package LLD.DesignPatterns.StateDesignPattern.ATMMachine;

import java.util.Scanner;

public class UserinterfaceImpl implements UserInterface{
    Scanner scanner;
    public UserinterfaceImpl(){
        scanner=new Scanner(System.in);
    }
    @Override
    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    @Override
    public int getPin() {
        System.out.println("Enter your PIN:");
        return scanner.nextInt();
    }

    @Override
    public int getAmountRequested() {
        System.out.println("Enter the amount:");
        return scanner.nextInt();
    }
}
