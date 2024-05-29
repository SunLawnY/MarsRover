package InputAndParser;

import Plateau.Mars;
import Rover.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminRemote {
    private List<Rover> rover;
    private Mars mars;

    public AdminRemote(Scanner scanner) {
        rover = new ArrayList<>();
        while (mars == null) {
            try {
                System.out.println("Generate a Map Using Inputted XY Coordinates");
                this.mars = Parser.mapParser(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void createRover(Scanner scanner) {
        System.out.println("How many Rover to deploy");
        int quantity = scanner.nextInt();
        for (int n = 0; n < quantity; n++) {
            boolean createComplete = false;
            while (!createComplete) {
                try {
                    System.out.println("Initialize Rover " + (n+1) + " Using Inputted XY Coordinates");
                    rover.add(Parser.roverParser(scanner.nextLine(), mars));
                    if (n == quantity-1) {
                        createComplete = true;
                    } else {
                        n++;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void getRoverPosition() {
        for (Rover r : rover) {
            System.out.println(r.getPosition());
        }
    }


    public void performMovement(Scanner scanner) {
        for (int n = 0; n< rover.size(); n++) {
            boolean exitCommand = false;
            while (!exitCommand) {
                try {
                System.out.println("Provide Command Sequence LRMQ (Left/Right/Move/Quit) to Direct Rover " + (n + 1) + " Operations");
                ArrayList<MoveFunction> command = Parser.command(scanner.nextLine());
                for (MoveFunction f : command) {
                    if (f == MoveFunction.M) {
                        Performer.peformMoveForward(f, rover.get(n), mars);
                    } else if (f == MoveFunction.L || f == MoveFunction.R) {
                        Performer.performChangeDirection(f, rover.get(n));
                    } else {
                        exitCommand = true;
                    }
                }
                } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
            }
            getRoverPosition();
        }
    }
}


