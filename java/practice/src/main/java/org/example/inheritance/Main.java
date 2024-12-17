package org.example.inheritance;

public class Main {
    public static void main(String[] args) {
        Person.introduce();
        Student.introduce();

        Student s = new Student();
        s.study();

        System.out.println("parent");
        Parent parent = new Parent("parent Public value");
        System.out.println(parent.publicValue);
//        System.out.println(parent.privateValue); getter 가 필요
        System.out.println(parent.protectedValue);

        System.out.println("child");
//        Child child = new Child("child Public value");
        Child child = new Child("child Public value","child Value");
        System.out.println(child.publicValue);
//        System.out.println(child.privateValue);
        System.out.println(child.protectedValue);

        child.publicMethod();
//        parent.childMethod();
        child.publicMethod();
    }
}
