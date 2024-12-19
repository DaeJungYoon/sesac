package org.example.composition.prac;

public class Person {
    public String name;
    public Pencil pencil;

    public Person(String name, Pencil pencil) {
        this.name = name;
        this.pencil = pencil;
    }

   public void write(){
    pencil.write();
    }
}
