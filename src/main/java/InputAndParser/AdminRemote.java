package InputAndParser;
import Plateau.Mars;
import Rover.*;

import javax.swing.text.StyledEditorKit;
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
                System.out.println("Generate a Map Using Inputted XY Coordinates");
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
                System.out.println("Initialize a Rover Using Inputted XY Coordinates");
                rover.add(Parser.roverParser(scanner.nextLine(), mars));
                createComplete = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getRoverPosition(){
        for(Rover r: rover){
            System.out.println(r.getPosition());
        }
    }


    public void performMovement(Scanner scanner){
        boolean exitCommand = false;
        while (!exitCommand) {
            try {
                System.out.println("Provide Command Sequence LRMQ (Left/Right/Move/Quit) to Direct Rover Operations");
                ArrayList<MoveFunction> command = Parser.command(scanner.nextLine());
                for(Rover r : rover) {
                    for (MoveFunction f : command) {
                        if (f == MoveFunction.M) {
                            Performer.peformMoveForward(f, r, mars);
                        } else if (f == MoveFunction.L || f == MoveFunction.R){
                            Performer.performChangeDirection(f, r);
                        } else {
                            exitCommand = true;
                        }
                    }
                    getRoverPosition();
                }
            } catch (IllegalArgumentException | IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }
    }
}


