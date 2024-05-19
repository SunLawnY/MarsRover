package Rover;
import InputAndParser.Parser;

public class Rover {
    Position position;

    public Rover(int x, int y, Parser.CompassDirection facing) {
        this.position = new Position(x, y, facing);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(int x, int y, Parser.CompassDirection facing) {
        position.setX(x);
        position.setY(y);
        position.setFacing(facing);
    }
}
