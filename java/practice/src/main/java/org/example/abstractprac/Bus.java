package org.example.abstractprac;

public class Bus extends Vehicle implements AddPassengerable {
    protected static final int maxFuel = 300;
    int passenger;

    public Bus(String model) {
        super(model);
    }

    @Override
    public int speedIncrease(int amount) {
       return speed += amount;
    }

    @Override
    public int addPassenger() {
        return passenger += 1;
    }
}
