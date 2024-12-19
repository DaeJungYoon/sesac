package org.example.composition.prac;

public class Main {
    public static void main(String[] args) {
        Pencil pencilBlue = new Pencil("red");

        Person dd = new Person("dd", pencilBlue);
        dd.write();

        Engine hondaEngin=new Engine(30);
        Car redbullCar=new Car(hondaEngin,"redbull");
        System.out.println(redbullCar.speed);
        redbullCar.speedUpByHorsePower();
        System.out.println(redbullCar.speed);

//        new Person(name, 도구);
//
//        person.use() => 도구로 pencile => 연필을 사용하고
//                .user() 도구로 car를 가지고 있다 => 속력을 높이자


    }
}
