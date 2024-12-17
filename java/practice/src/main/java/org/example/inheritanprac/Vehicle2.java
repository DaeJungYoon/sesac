package org.example.inheritanprac;

public class Vehicle2 {
    public String model;
    protected int speed;
    public int fuel;
    protected static final int MAX_FUEL=100;

    public Vehicle2(String model) {
        this.model = model;
        this.speed = 0;
        this.fuel = 0;
    }

    public int speedIncrease(int amount){
       speed += amount;
        return speed;
    }

    public int addFuel(int amount){
        fuel += amount;
        if(fuel>getMaxFuel()){
            fuel=getMaxFuel();
        }
        return fuel;
    }


    public int getMaxFuel() {
        return MAX_FUEL;
    }

}
