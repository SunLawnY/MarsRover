package Rover;
import InputAndParser.Parser;
import Plateau.Mars;

import java.util.ArrayList;
import java.util.List;

public class Rover implements Runnable{
    Position position;
    List<MoveFunction> instruction;

    public Rover(int x, int y, Parser.CompassDirection facing) {
        this.position = new Position(x, y, facing);
        instruction = new ArrayList<>();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(int x, int y, Parser.CompassDirection facing) {
        position.setX(x);
        position.setY(y);
        position.setFacing(facing);
    }

    public List<MoveFunction> getInstruction() {
        return instruction;
    }

    public void setInstruction(List<MoveFunction> instruction) {
        this.instruction = instruction;
    }

    public void performMovement(){
        for (MoveFunction f : this.instruction) {
            if (f == MoveFunction.M) {
                Performer.peformMoveForward(f, this, Mars.getInstance(0, 0));
            } else if (f == MoveFunction.L || f == MoveFunction.R) {
                Performer.performChangeDirection(f, this);
            }
            System.out.println(this.getPosition());
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        this.performMovement();
    }
}
