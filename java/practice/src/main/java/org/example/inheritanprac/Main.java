package org.example.inheritanprac;

public class Main {
    public static void main(String[] args) {

//        Animall jelly = new Animall("jelly",3);
//        jelly.cries();
//
//        Dog mango = new Dog("jelly",3);
//        mango.cries();
//
//        Cat tom = new Cat("tom",2);
//        tom.cries();
//        tom.golgol();

        Vehicle jjang = new Vehicle("tesla", 300);
        jjang.speedIncrease();
        jjang.speedIncrease();
        jjang.speedIncrease();
        jjang.speedIncrease();
        System.out.println(jjang.getSpeed());
        System.out.println("000000000");
        Bus tayo = new Bus("tayo",400,8);
        if(Vehicle.isFuelOver(tayo.fuel)){
            System.out.println("tayo fuel over");
        }else {
            new Vehicle("tayo", tayo.fuel);
        }
        System.out.println(tayo.model);

        if(Vehicle.isFuelOver(tayo.fuel)){
            System.out.println("tayo fuel over");
        }else {
            new Vehicle("tayo", tayo.fuel);
        }
        System.out.println(tayo.model);

        System.out.println();
        System.out.println("vehicle2");
        Vehicle2 avn=new Vehicle2("Avant");
        avn.addFuel(40);
        avn.speedIncrease(70);
        System.out.println(avn.speed);
        System.out.println(Vehicle2.MAX_FUEL);

        System.out.println();
        System.out.println("Bus2");
        Bus2 cun = new Bus2("cun");
        cun.addFuel(30);
        cun.speedIncrease(13);
        System.out.println("cun.speed = " + cun.speed);
        System.out.println("Bus.MAX_FUEL = " + Bus2.MAX_FUEL);
        System.out.println("cun.addPassenger(3) = " + cun.addPassenger(3));
        cun.addFuel(400);
        System.out.println("cun.fuel = " + cun.fuel);



    }

}
