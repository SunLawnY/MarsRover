import Plateau.Plateau;
import Plateau.PlateauMap;
import RoverClass.Rover;
import RoverClass.RoverPosition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        PlateauMap map = null;
        RoverPosition position = null;

        System.out.println("Initializing map...");
        Thread.sleep(1000);
        //Set up the map

        while (map == null || position == null) {
            while (map == null) {
                System.out.println("Enter map X/Y Coordinate (Format: X Y))");
                String mapInput = scanner.nextLine();
                try {
                    map = new InputParser().setMap(mapInput);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input detected, please try again");
                    map = null;
                }
            }
            while (position == null) {
                System.out.println("Please provide the X/Y Coordinate (Format: X Y Facing[N/E/S/W])");
                String landingInput = scanner.nextLine();
                try {
                    position = new InputParser().setLanding(landingInput);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Input detected, please try again");
                    position = null;
                }
            }

            try {
                if (position.getPositionX() > map.getGridX() || position.getPositionY() > map.getGridY()) {
                    throw new IllegalArgumentException("Landing Zone out of range");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Landing Zone out of range, reset map and landing zone");
                map = null;
                position = null;
            }
        }

        //Merge the rover into the Plateau.Plateau
        Rover rover = new Rover(position);
        Plateau plateau = new Plateau(map, rover);
        System.out.println(plateau);
        scanner.close();

    }
}
