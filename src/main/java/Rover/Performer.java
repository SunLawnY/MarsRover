package Rover;

import InputAndParser.Parser;
import Plateau.Mars;

public class Performer {
    MoveFunction moveFunction;

    public static void performChangeDirection(MoveFunction moveFunction, Rover rover) {
        switch (moveFunction) {
            case L -> {
                if (rover.position.getFacing() == Parser.CompassDirection.N) {
                    rover.setPosition(rover.position.getX(), rover.position.getY(), Parser.CompassDirection.W);
                } else if (rover.position.getFacing() == Parser.CompassDirection.W) {
                    rover.setPosition(rover.position.getX(), rover.position.getY(), Parser.CompassDirection.S);
                } else if (rover.position.getFacing() == Parser.CompassDirection.S) {
                    rover.setPosition(rover.position.getX(), rover.position.getY(), Parser.CompassDirection.E);
                } else if (rover.position.getFacing() == Parser.CompassDirection.E) {
                    rover.setPosition(rover.position.getX(), rover.position.getY(), Parser.CompassDirection.N);
                }
            }
            case R -> {
                if (rover.position.getFacing() == Parser.CompassDirection.N) {
                    rover.setPosition(rover.position.getX(), rover.position.getY(), Parser.CompassDirection.E);
                } else if (rover.position.getFacing() == Parser.CompassDirection.E) {
                    rover.setPosition(rover.position.getX(), rover.position.getY(), Parser.CompassDirection.S);
                } else if (rover.position.getFacing() == Parser.CompassDirection.S) {
                    rover.setPosition(rover.position.getX(), rover.position.getY(), Parser.CompassDirection.W);
                } else if (rover.position.getFacing() == Parser.CompassDirection.W) {
                    rover.setPosition(rover.position.getX(), rover.position.getY(), Parser.CompassDirection.N);
                }
            }
        }
    }

    public static void performMoveForward(MoveFunction moveFunction, Rover rover) {
        Mars mars = Mars.getInstance();
        int marsX = mars.getXAxis();
        int marsY = mars.getYAxis();
        int roverX = rover.position.getX();
        int roverY = rover.position.getY();
        Parser.CompassDirection face = rover.position.getFacing();
        switch (face) {
            case N -> {
                if (roverY < marsY) {
                    rover.position.setY(roverY + 1);
                } else {
                    throw new IndexOutOfBoundsException("Error: Rover is at the northern edge of the map and cannot move further north.");
                }
            }
            case S -> {
                if (roverY > 0) {
                    rover.position.setY(roverY - 1);
                } else {
                    throw new IndexOutOfBoundsException("Error: Rover is at the southern edge of the map and cannot move further south.");
                }
            }
            case E -> {
                if (roverX < marsX) {
                    rover.position.setX(roverX + 1);
                } else {
                    throw new IndexOutOfBoundsException("Error: Rover is at the eastern edge of the map and cannot move further east.");
                }
            }
            case W -> {
                if (roverX > 0) {
                    rover.position.setX(roverX - 1);
                } else {
                    throw new IndexOutOfBoundsException("Error: Rover is at the western edge of the map and cannot move further west.");
                }
            }
        }
    }
}
