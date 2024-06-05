package InputAndParser;

import Rover.*;
import Plateau.Mars;

import java.util.ArrayList;

public class Parser {

    public enum CompassDirection {
        E, S, W, N;
    }

    public static void mapParser(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Error: XY coordinates are required to generate a map. Please provide the necessary inputs.");
        }
        try {
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);

            if (x <= 0 || y <= 0) {
                throw new IllegalArgumentException("Error: The provided XY coordinates are invalid. Please ensure they fall within the permissible range.");
            }
            System.out.println("Map created, the size is " + x + "x" + y);
            Mars.setInstance(x, y);
        } catch (NumberFormatException e) {
            System.out.println("Error: Coordinates must be numeric values. Please re-enter the XY coordinates.");
        }
    }

    public static Rover roverParser(int n, String input, Mars mars) {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Error: Invalid input format. Please provide exactly three components: X coordinate, Y coordinate, and facing direction.");
        }
        int x;
        int y;
        try {
            x = Integer.parseInt(parts[0]);
            y = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: Coordinates must be numeric values. Please re-enter the XY coordinates.");
        }

        int a = mars.getXAxis();
        int b = mars.getYAxis();
        if (x < 0 || y < 0 || x > a || y > b) {
            throw new IllegalArgumentException("Error: Coordinates out of bounds. X and Y must be at least 0 and within the map range.");
        }

        String partInput = parts[2];
        CompassDirection facing;
        try {
            facing = CompassDirection.valueOf(partInput.toUpperCase());
            System.out.println("Coordinates acquired, situated at " + x + " " + y + " facing " + facing);
            return new Rover(n+1, x, y, facing);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error: Invalid facing direction. Please enter a valid direction: E, S, W, or N.");
        }
    }

    public static ArrayList<MoveFunction> command(String input) {
        ArrayList<MoveFunction> result = new ArrayList<>();
        if (input.isEmpty()){
            System.out.println("In");
        }
        char[] parserList = input.toCharArray();
        MoveFunction function;
        for (char c : parserList) {
            try {
                function = MoveFunction.valueOf(String.valueOf(c).toUpperCase());
                result.add(function);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Error: Invalid command '" + c + "'. Instructions should only contain L, R or M");
            }
        }
        return result;
    }
}
