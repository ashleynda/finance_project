package BankApp;

import javax.swing.*;
import java.util.Scanner;

public class ATM {
    private  static Scanner input = new Scanner(System.in);
    private static Bank bank = new Bank("GTB");
    public static void main(String[] args) {


        displayMethod("""
                1. Register""");

        String option = inputMethod("Enter option:  ");
        if (option.equalsIgnoreCase("1"))
            Register();
    }
    private static String inputMethod(String prompt){
        return JOptionPane.showInputDialog(null, prompt);
    }

    private static void Register() {
        try {
            String firstName = inputMethod("Enter first name:  ");
            String lastName = inputMethod("Enter last name:  ");
            String pin = inputMethod("Enter pin:  ");
            bank.register(firstName, lastName, pin);
            displayMethod("Registration successful");
        } catch (IllegalArgumentException Error) {
            displayMethod(Error.getMessage());
        }
        customerPage();
    }

    private static void Deposit() {
        try {
            String accountNumber = inputMethod("Enter account number:  ");
            String amount = inputMethod("Enter amount:  ");
            bank.deposit(Integer.parseInt(amount), accountNumber);
            displayMethod("Deposit successful");
        } catch (IllegalArgumentException Error) {
            displayMethod(Error.getMessage());
        }
        customerPage();
    }
    private static void Transfer_GTB() {
        try {
            String receiverNumber = inputMethod("Enter receiver's number:  ");
            String senderNumber = inputMethod("Enter sender's name:  ");
            String amount = inputMethod("Enter amount:  ");
            String pin = inputMethod("Enter your pin:  ");
            bank.transfer(senderNumber, receiverNumber, Integer.parseInt(amount), pin);
            displayMethod("Transfer successful");
        } catch (IllegalArgumentException Error) {
            displayMethod(Error.getMessage());
        }
    }
    private static void Withdrawal() {
        try {
            String amount = inputMethod("Enter amount:  ");
            String accountNumber = inputMethod("Enter account number:  ");
            String pin = inputMethod("Enter your pin:  ");
            bank.withdraw(Integer.parseInt(amount), accountNumber, pin);
            displayMethod("Withdrawal successful");
        } catch (IllegalArgumentException Error) {
            displayMethod(Error.getMessage());
        }
        customerPage();
    }
    private static void customerPage() {

        displayMethod("""
                            
                1. Deposit
                2. Trsf-GTB
                3. Withdrawal
                4. Next""");
        String option = inputMethod("Enter option:  ");
        if (option.equalsIgnoreCase("1"))
            Deposit();
        if (option.equalsIgnoreCase("2"))
            Transfer_GTB();
        if (option.equalsIgnoreCase("3"))
            Withdrawal();
    }
    private static void displayMethod(String message){
        JOptionPane.showMessageDialog(null, message);
    }

}
