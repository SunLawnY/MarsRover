package Plateau;

import RoverClass.Rover;

public class Plateau {
    PlateauMap plateauMap;
    Rover rover;

    public Plateau(PlateauMap plateauMap, Rover rover) throws InterruptedException {
        System.out.println("Approaching designated landing zone, commencing descent in");
        Thread.sleep(1000);
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        this.plateauMap = plateauMap;
        this.rover = rover;
        System.out.println("Touchdown achieved!");
        Thread.sleep(2000);
    }

    @Override
    public String toString() {
        return "Welcome to Mars, the size here is " + plateauMap.reporting() + "\nYou are now at " + rover.reporting();
    }

}
