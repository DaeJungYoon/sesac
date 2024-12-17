package org.example;

public class Calc {
    int a;
    int b;

    public Calc(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int sum(){
       return this.a + this.b;
    }

    int decuct(){
        return this.a-this.b;
    }

    int divi(){
        return this.a/this.b;
    }

    int mul(){
        return this.a*this.b;
    }
}
