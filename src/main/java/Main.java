import Plateau.Plateau;
import Plateau.PlateauMap;
import RoverClass.Rover;
import RoverClass.RoverFacing;
import RoverClass.RoverPosition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner setUp = new Scanner(System.in);
        //Set up the map
        PlateauMap map = new PlateauMap(setUp);
        //Set up the Rover
        RoverPosition position = new RoverPosition(setUp);
        Rover rover = new Rover(position);
        //Merge the rover into the Plateau.Plateau
        Plateau plateau = new Plateau(map, rover);
        System.out.println(plateau);
        setUp.close();
    }
}
