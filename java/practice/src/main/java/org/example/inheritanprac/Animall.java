package org.example.inheritanprac;

public class Animall {
    protected String name;
    private int age;
//    String crying;

    public Animall(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void cries(){
        System.out.println("cry");
    }

}
