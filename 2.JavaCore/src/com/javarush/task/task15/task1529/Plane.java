package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    public int passengers;
    @Override
    public void fly() {
    }

    public Plane(int p) {
        this.passengers = p;
    }
}
