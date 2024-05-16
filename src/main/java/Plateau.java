public class Plateau {
    int gridX;
    int gridY;
    Rover rover;

    public Plateau(int gridX, int gridY, Rover rover) {
        this.gridX = gridX;
        this.gridY = gridY;
        this.rover = rover;

        if(rover.positionX>gridX || rover.positionY>gridY || rover.positionX<0 || rover.positionY<0){
            System.out.println("Invalid input");;
        } else {

        }
    }
}
