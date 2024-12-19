package org.example.composition;

public class ComBuilding {
    private Address address;

    public ComBuilding(Address address) {
        this.address = address;
    }

    public void showAddress(){
        System.out.println("cityyy : "+ this.address.getCity());
        System.out.println("street : "+ this.address.getStreet());
      }
}
