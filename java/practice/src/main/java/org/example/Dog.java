package org.example;

public class Dog {

    String kingOf;
    String name;


    Dog(String kingOf, String name) {
        this.kingOf = kingOf;
        this.name = name;
    }

    void dogSitOrder(){
        System.out.println(this.name + " sit");
    }
    void dogHandOrder(){
        System.out.println(this.name + " hand");
    }
}
