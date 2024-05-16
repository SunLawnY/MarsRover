package RoverClass;

public class Rover {
    RoverPosition roverPosition;

    public Rover(RoverPosition roverPosition) {
        this.roverPosition = roverPosition;
    }

    public String reporting() {
        return "X: " + getPositionX() + " Y: " + getPositionY() + " Facing: " + getFacing();
    }

    public int getPositionX() {
        return roverPosition.getPositionX();
    }

    public int getPositionY() {
        return roverPosition.getPositionY();
    }

    public RoverFacing getFacing() {
        return roverPosition.getFacing();
    }

}
