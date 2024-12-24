package org.example.vendingmachine;

public class Main {
    public static void main(String[] args) {

        Products coke = new Products("coke",1200);
        Products soda = new Products("soda",1000);
        Products water = new Products("water",800);
        Payments payments = new Payments(10000,Payment.CASH);
        Customer customer = new Customer("david",payments);
        ProductsManagement productsManagement = new ProductsManagement(payments);
        productsManagement.addProduct(coke);
        productsManagement.addProduct(coke);
        productsManagement.addProduct(coke);
        productsManagement.addProduct(coke);
        productsManagement.addProduct(coke);
        productsManagement.addProduct(soda);
        productsManagement.addProduct(soda);
        productsManagement.addProduct(soda);
        productsManagement.addProduct(soda);
        productsManagement.addProduct(soda);
        productsManagement.addProduct(water);
        productsManagement.addProduct(water);
        productsManagement.addProduct(water);
        productsManagement.addProduct(water);
        System.out.println(productsManagement.getProducts().toString());
        productsManagement.productFind("coke");
        productsManagement.payProduct("coke",customer.payments);


    }
}
