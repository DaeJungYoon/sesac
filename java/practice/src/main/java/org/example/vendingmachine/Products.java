package org.example.vendingmachine;

public class Products {
    private String name;
    private int price;
    private int stockQuantity;

    public Products(String name, int price) {
        this.name = name;
        this.price = price;
        this.stockQuantity = 1;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    @Override
    public String toString(){
        return name;
    }
}
