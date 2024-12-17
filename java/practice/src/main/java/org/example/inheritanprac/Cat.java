package org.example.inheritanprac;

public class Cat extends Animall{
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void cries() {
        super.cries();
        System.out.println(name+" meow");
    }

    public void golgol(){
        System.out.println("golgol");
    }

}
