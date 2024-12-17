package org.example.modifierprac;

public class Person {
    private String name;
    public int age;
    double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
//    public Person(String name) {
//        this.name = name;
//        this.height = 129.0;
//
//    }

//    Person(){
//        this("deny");
//    }

    private void run(){
        System.out.println("running");
    }
    public void walk(){
        System.out.println("walking");
    }
    void study(){
        System.out.println("to study");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //    public String getName() {
//        return name;
//    }
//
//    public double getHeight() {
//        return height;
//    }

    public void showName(){
        System.out.println(getName());
    }
//    public double showHeight(){
//        return getHeight();
//    };

    public void showStudy(){
       study();
    }

}
