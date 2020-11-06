package com.company;

public class Cvetok {
    public Double deg;
    public String name;

    public Cvetok(String name, double x, double y){
        this.name = name;
        this.deg = Math.toDegrees(Math.atan(y/x));
    }
}
