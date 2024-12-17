package org.example.abstractprac;

public class Brucks extends Vehicle implements AddBaggageable,AddPassengerable{
    protected static final int maxFuel=1000;
    int baggage;
    int passenger;

    public Brucks(String model) {
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

    @Override
    public int addPassenger() {
        return passenger += 1;
    }
}
