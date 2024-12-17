package org.example.inheritance;

public class Child extends Parent{

    public  String childValue = "childValue";

    public Child(String publicvalue){
        super(publicvalue);
    }
    public Child(String publicvalue, String childValue){
        super(publicvalue);
        this.childValue = childValue;
    }

    public void childMethod() {
        System.out.println("childMethode");
    }

    public void publicMethod(){
        super.publicMethod();
        System.out.println(super.publicValue);
        System.out.println(super.protectedValue);
        System.out.println("child public method");
    }
}
