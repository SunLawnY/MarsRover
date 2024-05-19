package Rover;

import InputAndParser.Parser;

public class Position {
    private int x;
    private int y;
    private Parser.CompassDirection facing;

    public Position(int x, int y, Parser.CompassDirection facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Parser.CompassDirection getFacing() {
        return facing;
    }

    public void setFacing(Parser.CompassDirection facing) {
        this.facing = facing;
    }

    @Override
    public String toString() {
        return "Updated position X:" + getX() + " Y:" + getY() + " Facing:" + getFacing() + ".";
    }
}
