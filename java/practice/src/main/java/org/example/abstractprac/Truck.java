package org.example.abstractprac;

public class Truck extends Vehicle implements AddBaggageable{
    protected static final int maxFuel=250;
    int baggage;

    public Truck(String model) {
        super(model);
    }

    @Override
    public int speedIncrease(int amount) {
        return speed += amount;
    }

    @Override
    public int addBaggage() {
        return baggage += 1;
    }
}
