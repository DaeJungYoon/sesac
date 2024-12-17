package org.example.interfaceprac;

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle();
        System.out.println(rectangle.calculateArea());

        Triangle triangle =new Triangle();
        System.out.println(triangle.calculateArea());

        Dog dog = new Dog("jelly", 10,"puddle");
        dog.makeSound();

        Cat cat = new Cat("groom",3);
        cat.makeSound();

        makeThemSound(dog);
        makeThemSound(cat);
    }
    public static void makeThemSound(Animal animal){
        System.out.println("cry");
        animal.makeSound();
    }
//    public static void makeThemSound(Dog dog){
//        System.out.println("cry");
//        dog.makeSound();
//    }
//    public static void makeThemSound(Cat cat){
//        System.out.println("cry");
//        cat.makeSound();
//    }
}
