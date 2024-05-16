package Plateau;

import java.security.cert.X509Certificate;
import java.util.Scanner;

public class PlateauMap {
    protected static int gridX;
    protected static int gridY;

    public PlateauMap(Scanner setUp) {
        System.out.println("Step1: Setup the Map (Must be positive Integer)");
        System.out.println("Please input X coordinate");


        while (gridX <= 0) {
            gridX = setUp.nextInt();
            try {
                if (gridX <= 0) {
                    throw new IllegalArgumentException("Map size X must be greater then 1");
                }
                System.out.println("Map size X: " +gridX);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Please input X coordinate");
            }
        }
//        while (gridX < 0) {
//            System.out.println("Coordinate must be greater then 0");
//            System.out.println("Please input X coordinate");
//            gridX = setUp.nextInt();
//        }
        System.out.println("Please input Y coordinate");

        while (gridY <= 0) {
            gridY = setUp.nextInt();
            try {
                if (gridY < 0) {
                    throw new IllegalArgumentException("Map size Y must be greater then 1");
                }
                System.out.println("Map size Y: " +gridY);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Please input Y coordinate");
            }
        }
//        while (gridY < 0) {
//            System.out.println("Coordinate must be greater then 0");
//            System.out.println("Please input Y coordinate");
//            gridY = setUp.nextInt();
//        }
        System.out.println("Map setup complete. Size X:" + gridX + " Y:" + gridY);
    }

    public static int getGridX() {
        return gridX;
    }

    public static void setGridX(int gridX) {
        PlateauMap.gridX = gridX;
    }

    public static int getGridY() {
        return gridY;
    }

    public static void setGridY(int gridY) {
        PlateauMap.gridY = gridY;
    }

    public static String reporting(){
        return "X: " + getGridX() + " Y: " + getGridY();
    }
}
