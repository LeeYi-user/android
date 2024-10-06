package com.example.app1005;

public class Square implements AreaInterface {
    private int side;

    @Override
    public double area() {
        return side * side;
    }
}
