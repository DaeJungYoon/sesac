package org.example.abstractprac;

public class Main {
    public static void main(String[] args) {

        System.out.println("Truck");
        Bus bus = new Bus("metro City");
       bus.speedIncrease(200);
       System.out.println("bus speed = "+bus.speed);
//       bus.addPassenger();
//       System.out.println(bus.passenger);
        System.out.println(bus.maxFuel);
        System.out.println(bus.model);
        addPassengers(bus);
        addPassengers(bus);
        bus.speedIncrease(200);
        System.out.println("bus speed = "+bus.speed);

        System.out.println();
        System.out.println("Truck");
        Truck truck = new Truck("cyber");
        System.out.println(truck.model);
        System.out.println(truck.maxFuel);
        truck.speedIncrease(300);
        System.out.println("truck speed = "+truck.speed);
        truck.addBaggage();
        addBaggages(truck);
        addBaggages(truck);

        System.out.println();
        System.out.println("Brucks");
        Brucks bruck = new Brucks("KING");
        System.out.println(bruck.model);
        System.out.println(bruck.maxFuel);
        bruck.speedIncrease(300);
        System.out.println("bruck speed = "+bruck.speed);
        brucksAddBaggages(bruck);
        brucksAddBaggages(bruck);
        brucksAddPassengers(bruck);
        brucksAddPassengers(bruck);








    }

    private static void addPassengers(Bus bus) {
        System.out.println("+1 Passenger");
        bus.addPassenger();
        System.out.println("now passenger = "+bus.passenger);
    }
    private static void addBaggages(Truck truck){
        System.out.println("+1 baggage");
        truck.addBaggage();
        System.out.println("now baggages = "+truck.baggage);

    }
    private static void brucksAddBaggages(Brucks bruck){
        System.out.println("+1 baggage");
        bruck.addBaggage();
        System.out.println("now baggages = "+bruck.baggage);
    }
    private static void brucksAddPassengers(Brucks bruck) {
        System.out.println("+1 Passenger");
        bruck.addPassenger();
        System.out.println("now passenger = "+bruck.passenger);
    }

}
