package InputAndParser;
import Rover.Rover;
import Plateau.Mars;

public class Parser {

    public enum CompassDirection {
        E,S,W,N;
    }

    public static Mars mapParser (String input){
        String[] parts = input.split(" ");
        System.out.println("*****Step1.1 test length must be 2*****");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Require X and Y coordinate");
        }
        try {
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            System.out.println("*****Step1.2 test must be number input*****");

            if (x <= 0 || y <= 0) {
                System.out.println("*****Step1.3 test negative input*****");
                throw new IllegalArgumentException("X/Y must be at least 1");
            }
            System.out.println("Map created, the size is " + x + "x" + y);
            return new Mars(x, y);
        } catch (NumberFormatException e) {
            System.out.println("X/Y must be an integer!");
            return null;
        }
    }

    public static Rover roverParser (String input, Mars mars){
        String[] parts = input.split(" ");
        System.out.println("*****Step2.1 test Length must be 3*****");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Require X, Y coordinate and a Facing Direction");
        }
        System.out.println("*****Step2.2*****");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        int a = mars.getxAxis();
        int b = mars.getyAxis();
        if (x < 0 || y < 0 || x > a || y > b) {
            System.out.println("*****Step2.3*****");
            throw new IllegalArgumentException("X/Y must be at least 0 and must be within map range");
        }
        System.out.println("*****Step2.4*****");
        String partInput = parts[2];
        CompassDirection facing;
        try {
            System.out.println("*****Step2.5*****");
            facing = CompassDirection.valueOf(partInput.toUpperCase());
            System.out.println("*****Step2.6*****");
            System.out.println("Coordinates acquired, situated at " + x + " " + y + " " + facing);
            return new Rover(x, y, facing);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid input. Please enter a valid facing direction E/S/W/N.");
        }
    }

//    public static
}
