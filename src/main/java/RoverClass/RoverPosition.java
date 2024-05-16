package RoverClass;

import Plateau.PlateauMap;

import java.util.Scanner;

public class RoverPosition {
    protected int positionX;
    protected int positionY;
    private RoverFacing facing;

    public RoverPosition(Scanner setUp) throws InterruptedException {
        System.out.println("Step2: Confirm landing position");
        System.out.println("X coordinate for Rover Landing");
        positionX = setUp.nextInt();
        while (positionX < 0 || positionX > PlateauMap.getGridX()) {
            System.out.println("Coordinate must be greater then 0 and within the grid X: " + PlateauMap.getGridX());
            System.out.println("X coordinate for Rover Landing");
            positionX = setUp.nextInt();
        }
        System.out.println("Y coordinate for Rover Landing");
        positionY = setUp.nextInt();
        while (positionY < 0) {
            System.out.println("Coordinate must be greater then 0 and within the grid Y " + PlateauMap.getGridY());
            System.out.println("Y coordinate for Rover Landing");
            positionY = setUp.nextInt();
        }
        facing = null;
        do {
            System.out.println("Facing direction: E/S/W/N");
            String input = setUp.next();

            try {
                facing = RoverFacing.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a valid facing direction E/S/W/N.");
            }
        } while (facing == null);
        Thread.sleep(1000);
        System.out.println("Coordinates acquired, situated at X:" + positionX + " Y:" + positionY + " Direction:" + facing);
        Thread.sleep(1000);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public RoverFacing getFacing() {
        return facing;
    }

    public void setFacing(RoverFacing facing) {
        this.facing = facing;
    }
}
