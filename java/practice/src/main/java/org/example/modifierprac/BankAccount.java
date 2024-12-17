package org.example.modifierprac;

public class BankAccount {
    private int balance;
    public int accountNum;
    private int password;

    public BankAccount(int password, int accountNum, int balance) {
        this.password = password;
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
