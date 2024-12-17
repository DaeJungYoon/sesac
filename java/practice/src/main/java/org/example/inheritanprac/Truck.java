package org.example.inheritanprac;

public class Truck extends Vehicle {

    int baggage;
    public int addBaggage(){
        return baggage +=1;
    }

    public Truck(String model, int fuel, int baggage) {
        super(model, fuel);
        if (fuel>300){
            System.out.println(model+"max fuel over");
            return;
        }
        this.baggage = baggage;
    }


}
