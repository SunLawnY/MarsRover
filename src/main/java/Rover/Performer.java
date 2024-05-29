package Rover;

import InputAndParser.Parser;
import Plateau.Mars;

public class Performer {
    MoveFunction moveFunction;

    public static void performChangeDirection(MoveFunction moveFunction, Rover rover) {
        switch (moveFunction) {
            case L -> {
                if (rover.position.getFacing() == Parser.CompassDirection.N) {
                    rover.setPosition(rover.getPosition().getX(), rover.getPosition().getY(), Parser.CompassDirection.W);
                } else if (rover.position.getFacing() == Parser.CompassDirection.W) {
                    rover.setPosition(rover.getPosition().getX(), rover.getPosition().getY(), Parser.CompassDirection.S);
                } else if (rover.position.getFacing() == Parser.CompassDirection.S) {
                    rover.setPosition(rover.getPosition().getX(), rover.getPosition().getY(), Parser.CompassDirection.E);
                } else if (rover.position.getFacing() == Parser.CompassDirection.E) {
                    rover.setPosition(rover.getPosition().getX(), rover.getPosition().getY(), Parser.CompassDirection.N);
                }
            }
            case R -> {
                if (rover.position.getFacing() == Parser.CompassDirection.N) {
                    rover.setPosition(rover.getPosition().getX(), rover.getPosition().getY(), Parser.CompassDirection.E);
                } else if (rover.position.getFacing() == Parser.CompassDirection.E) {
                    rover.setPosition(rover.getPosition().getX(), rover.getPosition().getY(), Parser.CompassDirection.S);
                } else if (rover.position.getFacing() == Parser.CompassDirection.S) {
                    rover.setPosition(rover.getPosition().getX(), rover.getPosition().getY(), Parser.CompassDirection.W);
                } else if (rover.position.getFacing() == Parser.CompassDirection.W) {
                    rover.setPosition(rover.getPosition().getX(), rover.getPosition().getY(), Parser.CompassDirection.N);
                }
            }
        }
    }

    public static void peformMoveForward(MoveFunction moveFunction, Rover rover, Mars mars){
        int marsX = mars.getxAxis();
        int marsY = mars.getyAxis();
        int roverX = rover.position.getX();
        int roverY = rover.position.getY();
        Parser.CompassDirection face = rover.getPosition().getFacing();
        switch (face) {
            case Parser.CompassDirection.N -> {
                if (roverY != marsY){
                    rover.position.setY(roverY+1);
                } else {
                    throw new IndexOutOfBoundsException("Error: Rover is at the northern edge of the map and cannot move further north.");
                }
            }
            case Parser.CompassDirection.S -> {
                if (roverY != 0){
                    rover.position.setY(roverY-1);
                } else {
                    throw new IndexOutOfBoundsException("Error: Rover is at the southern edge of the map and cannot move further south.");
                }
            }
            case Parser.CompassDirection.E -> {
                if (roverX != marsX){
                    rover.position.setX(roverX+1);
                } else {
                    throw new IndexOutOfBoundsException("Error: Rover is at the eastern edge of the map and cannot move further east.");
                }
            }
            case Parser.CompassDirection.W -> {
                if (roverX != 0){
                    rover.position.setX(roverX-1);
                } else {
                    throw new IndexOutOfBoundsException("Error: Rover is at the western edge of the map and cannot move further west.");
                }
            }
        }
    }
}
