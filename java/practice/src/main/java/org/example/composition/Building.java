package org.example.composition;

public class Building extends Address {

    public Building(String city, String street) {
        super(city, street);
    }
    public void showAddress(){
        System.out.println("city : " +getCity());
        System.out.println("city : " +getStreet());
    }
}
