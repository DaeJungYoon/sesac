package org.example.composition;

public class Main {
    public static void main(String[] args) {

        Building building1= new Building("city1","street1");
        building1.showAddress();
        Address a1 = new Address("ssfd","dfs");
        ComBuilding comBuilding = new ComBuilding(a1);

        comBuilding.showAddress();


    }
}
