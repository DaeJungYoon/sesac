package org.example;

public class Triangle {
    int width;
    int height;

    Triangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    double triangleArea(){
        return width * height /2;
    }

    int trianglePerimeter(){
        return width *3;
    }
}
