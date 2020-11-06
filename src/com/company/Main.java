package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Pole pole = new Pole(0, 0, 90);
        pole.addCvetok("Oduvanchik", 1, 3);
        pole.addCvetok("Oduvanchik", 1, 1.1);
        pole.addCvetok("Roza", 2, 2.1);
        pole.addCvetok("Roza", -1, 2);
        pole.addCvetok("Gibiskus", -1, -3);
        pole.addCvetok("Oduvanchik", -0.5, -4);
        pole.addCvetok("Roza", 0.5, -4);
        System.out.println(pole.poschitat());
    }
}
