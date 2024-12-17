package org.example.inheritanprac;

public class Dog extends Animall{
    private String breed;

    public Dog(String name, int age) {
        super(name, age);
        this.breed=breed;
    }

    @Override
    public void cries() {
        System.out.println(name+" bowwow");
    }
}
