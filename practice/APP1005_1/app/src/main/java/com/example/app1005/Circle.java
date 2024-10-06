package com.example.app1005;

public class Circle implements AreaInterface {
    private int r;

    @Override
    public double area() {
        return PI * r * r;
    }
}
