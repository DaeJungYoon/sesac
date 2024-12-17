package org.example;

public class Car {
    String name;
    int speed;

    public Car(String name, int speed) {
        this.name = name;
    }

    void speedIncrease(){
        this.speed +=10;
    }
    void speedDecrease(){
        this.speed -=10;
    }

    void carCurrent(){
        System.out.println(name);
        System.out.println(this.speed);
    }
}
