package BankApp;
public class Account {
    private String pin;
    public int getBalance(String number) {
        return this.balance;
    }
    private String accountNumber;
    private String accountName;
    private int balance;

    public Account(String accountNumber, String accountName, String pin) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.pin = pin;
    }
    public int checkBalance(String pin) {
        if(validate(pin)) return balance;
        return 0;
    }

    private boolean validate(String pin) {
        if (this.pin.equals(pin)){
            return true;
        }
        else {
            throw new IllegalArgumentException("Ya pin is not correct");
        }
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount, String pin) {
        if (amount > 0){
            if (validate(pin) && amountGreater(amount))
                balance -= amount;
        }
        else {
            throw new IllegalArgumentException("OLE!!!!! you no get money");
        }
    }
    private boolean amountGreater(int amount) {
        return amount <= balance;
    }

    public String getAccountNumber(String accountNumber) {
        return this.accountNumber;
    }

    public String getAccountName() {
        return this.accountName;
    }
}



