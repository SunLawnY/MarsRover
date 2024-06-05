package Rover;

import InputAndParser.*;

import java.util.ArrayList;
import java.util.List;

public class Rover implements Runnable {
    int id;
    Position position;
    List<MoveFunction> instruction;

    public Rover(int id, int x, int y, Parser.CompassDirection facing) {
        this.id = id;
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

    public void performMovement() {
        for (MoveFunction f : this.instruction) {
            if (checkCollision(AdminRemote.rovers)) {
                System.out.println("Circuit's dead, there's something wrong\n" +
                        "Can you hear me, Rover "+ this.id + "\n" +
                        "Can you hear me, Rover "+ this.id + "\n" +
                        "Can you hear me, Rover "+ this.id + "\n");
                break;
            }
            if (f == MoveFunction.M) {
                Performer.performMoveForward(f, this);
            } else if (f == MoveFunction.L || f == MoveFunction.R) {
                Performer.performChangeDirection(f, this);
            }

            System.out.println("Rover " + this.id + " " + this.getPosition());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean checkCollision(List<Rover> rovers) {
        for (Rover other : rovers) {
            if (other != this && other.position.getX() == this.position.getX() && other.position.getY() == this.position.getY()) {
                System.out.println("Collision detected between rover " + this.id + " and rover " + other.id);
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {
        this.performMovement();
    }
}
