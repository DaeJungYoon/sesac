package org.example.inheritanprac;

public class Bus extends Vehicle{
    int passenger;
    public int addPassenger(){
       return passenger +=1;
     }

    public Bus(String model, int fuel,int passenger) {
        super(model, fuel);
        if (fuel>300){
            System.out.println(model+"max fuel over");
            return;
        }

    }

    public int speedIncrease(){
       return super.speedIncrease();
    }
    public int getSpeed(){
      return super.getSpeed();
    }

}
