package org.example.vendingmachine;

public enum Payment {
    CASH("cash"),
    CREDIT("credit");

    private String pay;

    Payment(String pay) {
        this.pay = pay;
    }

    public String getPay() {
        return pay;
    }


}
