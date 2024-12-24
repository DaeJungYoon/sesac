package org.example.vendingmachine;

public class Customer extends Users{
    public Payments payments;
    public Customer(String name, Payments payments) {
        super(name);
        this.payments = payments;
    }

}
