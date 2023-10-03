package BankApp;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private String bankName;
    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public Account find(String accountNumber) {
        for (Account access : accounts) {
            if(access.getAccountNumber(accountNumber).equals(accountNumber))return access;
        }
        throw new IllegalArgumentException("Account not found");
    }


    public void register(String firstName, String lastName, String pin) {
        String accountName = firstName + " " + lastName;
        Account newAccount = new Account(generateAccountNumber(), accountName, pin);
        accounts.add(newAccount);
    }

    private String generateAccountNumber() {
        return accounts.size() + 1 +"";
    }
    public int checkBalance(String number, String number1) {
        return find(number).getBalance(number1);
    }

    public void deposit(int amount, String accountNumber) {
        find(accountNumber).deposit(amount);
    }

    public void withdraw(int amount, String number,String pin) {
        find(number).withdraw(amount,pin);
    }


    public void transfer(String senderNumber, String receiverNumber, int amount, String pin){
        find(senderNumber).withdraw(amount,pin);
        find(receiverNumber).deposit(amount);
    }
}


