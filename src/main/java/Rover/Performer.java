package Rover;

import InputAndParser.Parser;

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

    public static void peformMove(MoveFunction moveFunction, Rover rover){
        if (rover.position.getFacing() == Parser.CompassDirection.N){
            rover.position.setY(rover.position.getY()+1);
        }
    }
}
