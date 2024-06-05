package Plateau;

public class Mars {
    private final int xAxis;
    private final int yAxis;

    private static Mars instance;

    public Mars(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public static Mars getInstance() {
        if (instance == null) {
            instance = new Mars(0, 0);
        }
        return Mars.instance;
    }

    public static void setInstance(int x, int y) {
        instance = new Mars(x, y);
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

}
