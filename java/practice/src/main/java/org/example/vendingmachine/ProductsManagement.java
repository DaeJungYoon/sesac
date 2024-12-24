package org.example.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class ProductsManagement implements ProductAddAble,ProductByNameFindAble,ProductPayAble,BalanceAble {
    private int sales;
    private Payments payments;
    private List<Products> products;

    @Override
    public String toString() {
        return "ProductsManagement{" +
                "products=" + products +
                '}';
    }

    public List<Products> getProducts() {
        return products;
    }

    public ProductsManagement(Payments payments) {
        this.sales = 0;
        this.payments = payments;
        this.products = new ArrayList<>();
    }


    // 상품 추가 기능
    @Override
    public List<Products> addProduct(Products product) {
        products.add(product);
        product.setStockQuantity(+1);
        return products;
    }

    // 상품 확인 기능
    @Override
    public Products productFind(String productsName) {
        for(Products product : products ){
            if(product.getName().equals(productsName)){
                System.out.println(product);
                return product;
            }
        }

        return null;
    }

    // 상품 결제 기능
    @Override
    public Products payProduct(String productsName, Payments payments) {
        for (Products product : products){
            if(!(product.getStockQuantity()<=0)){
            product.setStockQuantity(-1);
            sales += product.getPrice();
            }
        }
        System.out.println(productsName+" out!");
        return null;
    }


    // 잔 돈 계산 기능
    @Override
    public void returnBalance(Payments payments) {
        for(Products product : products){
            if(payments.payment == Payment.valueOf("CASH")){
                int i = payments.getAmount() -product.getPrice();
                System.out.println("return Balance = "+i);
            } else if (payments.payment == Payment.valueOf("CREDIT")) {
                if(!((payments.getAmount() -product.getPrice())>0)){
                    System.out.println("lack balance");
                }
            }else {
                System.out.println("pay error");
            }
        }
    }
}
