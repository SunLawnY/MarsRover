public class Rover {
    int positionX;
    int positionY;
    enum Point {
        N,
        S,
        E,
        W
    }
    Point point;
    enum Instruction{
        L,
        R,
        M
    }
    Instruction instruction;

    public Rover(int positionX, int positionY, Point point) {
        if (positionX < 0 || positionY <0){
            System.out.println("Unrealistic command");
        } else {
            this.positionX = positionX;
            this.positionY = positionY;
        }
        this.point = point;
    }



    @Override
    public String toString() {
        return String.format("Rover is now at X:%d Y:%d facing:%s", positionX, positionY, point);
    }

}
