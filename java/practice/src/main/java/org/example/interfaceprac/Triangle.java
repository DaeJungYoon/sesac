package org.example.interfaceprac;

public class Triangle extends Shape {
    public int width = 10;
    public int heigth = 20;

    @Override
    public int calculateArea() {
        return width*heigth/2;
    }
}
