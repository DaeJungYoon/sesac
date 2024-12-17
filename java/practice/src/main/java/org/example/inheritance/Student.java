package org.example.inheritance;

public class Student extends Person{
//    String name;
//    int age;
    int studentNum;
//    public void introduce(){
//        System.out.println("hello"+name);
//    }
   public static void introduce(){
        System.out.println("hello im student");
    }
    public void study(){
        System.out.println("studying");
    }
}
