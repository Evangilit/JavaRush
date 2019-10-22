package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        Horse horse1 = new Horse("Karina", 3, 0);
        Horse horse2 = new Horse("Helga", 3, 0);
        Horse horse3 = new Horse("Jessika", 3, 0);
        List<Horse> ourHorses = new ArrayList<>();
        ourHorses.add(horse1);
        ourHorses.add(horse2);
        ourHorses.add(horse3);
        game = new Hippodrome(ourHorses);
        game.run();
        game.printWinner();
    }

    public Horse getWinner(){
        Horse theFastest = horses.get(0);
        for (Horse horse: horses){
            if (horse.getDistance() > theFastest.getDistance()) theFastest = horse;
        }
        return theFastest;
    }

    public void printWinner(){
        System.out.println(String.format("Winner is %s!", getWinner().getName()));
    }

    public void run(){
        for (int i = 0; i < 100; i++) {
            this.move();
            this.print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
    }

    public void print(){
        for (Horse horse: horses){
            horse.print();
        }
        System.out.println();
    }

    public void move(){
        for (Horse horse: horses){
            horse.move();
        }
    }
}
