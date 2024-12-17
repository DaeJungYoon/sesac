package org.example.inheritanprac;

public class Bus2 extends Vehicle2{
    protected static final int MAX_FUEL = 300;
    int passenger;


    public Bus2(String model) {
        super(model);
        this.passenger = 0;
    }
    public int addPassenger(int amount){
        passenger += amount;
        return passenger;
    }



    @Override
    public int getMaxFuel(){
        return MAX_FUEL;
    }

}
