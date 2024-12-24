package org.example.vendingmachine;

public class Payments {
    private int amount;
    public Payment payment;


    public Payments(int amount, Payment payment) {
        this.amount = amount;
        this.payment = payment;
    }

    public int getAmount() {
        return amount;
    }

}
