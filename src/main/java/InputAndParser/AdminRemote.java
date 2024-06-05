package InputAndParser;

import Plateau.Mars;
import Rover.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AdminRemote{
    private final List<Rover> rovers;
    private Mars mars;

    public AdminRemote(Scanner scanner) {
        rovers = new ArrayList<>();
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
        scanner.nextLine();
        for (int n = 0; n < quantity; n++) {
            boolean createComplete = false;
            while (!createComplete) {
                try {
                    System.out.println("Initialize Rover " + (n + 1) + " Using Inputted XY Coordinates");
                    rovers.add(Parser.roverParser(scanner.nextLine(), mars));
                    createComplete = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void storeTheInstruction(Scanner scanner) {
        for (int n = 0; n < rovers.size(); n++) {
            while (rovers.get(n).getInstruction().isEmpty()) {
                try {
                    System.out.println("Provide Command Sequence LRM (Left/Right/Move) to Direct Rover " + (n + 1) + " Operations");
                    ArrayList<MoveFunction> command = Parser.command(scanner.nextLine());
                    rovers.get(n).setInstruction(command);
                    System.out.println(rovers.get(n).getInstruction());
                } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void startAllRovers() {
        for (Rover r : rovers) {
            Thread thread = new Thread(r);
            thread.start();
        }
    }

//    public void performMovement() {
//
//        for (MoveFunction f : rovers.get(roverNumber).getInstruction()) {
//            if (f == MoveFunction.M) {
//                Performer.peformMoveForward(f, rovers.get(roverNumber), mars);
//            } else if (f == MoveFunction.L || f == MoveFunction.R) {
//                Performer.performChangeDirection(f, rovers.get(roverNumber));
//            }
//            System.out.println("Performing instruction for Rover " + roverNumber + ", Receiving position: " + rovers.get(roverNumber).getPosition());
//        }
//
//    }



    public List<Rover> getRovers() {
        return rovers;
    }

    public Mars getMars() {
        return mars;
    }
}


