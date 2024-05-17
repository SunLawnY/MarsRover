import Plateau.PlateauMap;
import RoverClass.RoverFacing;
import RoverClass.RoverPosition;

import java.util.InputMismatchException;

public class InputParser {

    public PlateauMap setMap(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Require X and Y coordinate");
        }
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        try {
            if (x <= 0 || y <= 0) {
                throw new IllegalArgumentException("X/Y must be at least 1");
            }
            System.out.println("Map initialized, the size is " + x + "x" + y);
            return new PlateauMap(x, y);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public RoverPosition setLanding(String input) throws InterruptedException {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Require X, Y coordinate and a Facing Direction");
        }
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("X/Y must be at least 1");
        }
        String partInput = parts[2];
        RoverFacing facing;
        try {
            facing = RoverFacing.valueOf(partInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please enter a valid facing direction E/S/W/N.");
            return null;
        }
        System.out.println("Coordinates acquired, situated at " + x + " " + y + " " + facing);
        Thread.sleep(2000);
        return new RoverPosition(x, y, facing);
    }
}
