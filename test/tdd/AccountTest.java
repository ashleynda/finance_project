package tdd;

import org.junit.jupiter.api.Test;
import BankApp.Account;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    @Test
    public void canDepositMoneyIntoAccountTest(){
        Account account = new Account("accountNumber", "accountName", "pin");
        assertEquals(0, account.checkBalance("pin"));
        account.deposit(5000);
        assertEquals(5000, account.checkBalance("pin"));
    }
    @Test
    public void canWithdrawMoneyFromAccountTest(){
        Account account = new Account("accountNumber", "accountName", "pin");
        assertEquals(0, account.checkBalance("1234"));
        account.deposit(10_000);
        account.withdraw(8_000, "1234");
    }
    @Test
    public void cannotWithdrawMoreThanAmountInTest(){
        Account account = new Account("accountNumber", "accountName", "1234");
        assertEquals(0, account.checkBalance("1234"));
        account.deposit(100_000);
        assertEquals(100_000, account.checkBalance("1234"));
        account.withdraw(200_000_000, "1234");
        assertEquals(100_000, account.checkBalance("1234"));
    }
    @Test
    public void cannotWithdrawNegativeThanBalanceInTest(){
        Account account = new Account("accountNumber", "accountName", "1234");
        assertEquals(0, account.checkBalance("1234"));
        account.deposit(50_000);
        assertEquals(50_000, account.checkBalance("1234"));
        account.withdraw(-50_000, "1234");
        assertEquals(50_000, account.checkBalance("1234"));
    }
    @Test
    public void thatAccountCanCheckBalance(){
        Account account = new Account( "accountNumber", "accountName", "1234");
        assertEquals(0, account.checkBalance("1234"));
        account.deposit(5_000);
        assertEquals(5_000, account.checkBalance("1234"));
    }
    @Test
    public void thatAccountCannotWithdrawWithWrongPin(){
        Account account = new Account("accountNumber", "accountName", "1234");
        assertEquals(0, account.checkBalance("1234"));
        account.deposit(10_000);
        assertEquals(10_000, account.checkBalance("1234"));
        account.withdraw(5_000, "1434");
        assertEquals(10_000, account.checkBalance("1234"));
    }
}
