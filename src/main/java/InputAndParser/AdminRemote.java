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
        while (mars == null){
            try {
                System.out.println("*****Step1*****");
                this.mars = Parser.mapParser(scanner.nextLine());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void createRover(Scanner scanner){
        boolean createComplete = false;
        while (!createComplete) {
            try {
                System.out.println("*****Step2*****");
                rover.add(Parser.roverParser(scanner.nextLine(), mars));
                createComplete = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getRoverFacing(){
        for(Rover r: rover){
            System.out.println(r.getPosition());
        }
    }

    public void performLeftRight(MoveFunction function){
        for(Rover r: rover){
            Performer.performChangeDirection(function, r);
        }
    }

    public void performMove(MoveFunction function){
        for(Rover r: rover){
            Performer.peformMove(function, r);
        }
    }
}


