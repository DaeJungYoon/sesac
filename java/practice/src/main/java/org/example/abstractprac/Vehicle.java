package org.example.abstractprac;

public abstract class Vehicle {
    public String model;
    protected int speed;
    public int fuel;
    protected static final int maxFuel=100;

    public Vehicle(String model) {
        this.model = model;
        this.speed = 0;
        this.fuel = 0;
    }
    public abstract int speedIncrease(int amount);

}
