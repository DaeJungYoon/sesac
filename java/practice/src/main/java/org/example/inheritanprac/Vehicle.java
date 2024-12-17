package org.example.inheritanprac;

public class Vehicle {
    public String model;
    protected int speed;
    public int fuel;


    public Vehicle(String model,int fuel) {
        if (!isFuelOver(fuel)){
            System.out.println("fuel over");
            return;
        }else{
        this.model= model;
        this.fuel = fuel;
        }
    }

    public int speedIncrease(){
       return speed +=10;
    }

    public int getSpeed() {
        return speed;
    }

    public int getFuel() {
        return fuel;
    }

    public static boolean isFuelOver(int fuel){
        if(fuel<=100){
            return true;
        }else{
            return false;
        }
    }
}
