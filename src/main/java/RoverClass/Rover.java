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
        return this.roverPosition.getPositionX();
    }

    public int getPositionY() {
        return this.roverPosition.getPositionY();
    }

    public RoverFacing getFacing() {
        return this.roverPosition.getFacing();
    }

}
