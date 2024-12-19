package org.example.composition.prac;

public class Car implements SpeedUpAble {
    public Engine engine;
    public String model;
    public int speed;

    public Car(Engine engine, String model) {
        this.engine = engine;
        this.model = model;
        this.speed = 0;
    }
    @Override
    public void speedUpByHorsePower(){
        speed += 3*engine.horsePower;
        System.out.println("now speed = "+speed);
    }
}

