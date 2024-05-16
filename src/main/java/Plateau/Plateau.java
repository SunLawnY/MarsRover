package Plateau;

import RoverClass.Rover;

import java.util.Scanner;

public class Plateau {
    PlateauMap plateauMap;
    Rover rover;

    public Plateau(PlateauMap plateauMap, Rover rover) throws InterruptedException {
        System.out.println("Approaching designated landing zone, commencing descent.");
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        this.plateauMap = plateauMap;
        this.rover = rover;
        System.out.println("Touchdown achieved!");
    }

    @Override
    public String toString() {
        return "Welcome to Mars, the size here is " + PlateauMap.reporting() + "\nYou are now at " + rover.reporting();
    }

}
