package Plateau;

public class Mars {
    private final int xAxis;
    private final int yAxis;

    private static Mars instance;

    public Mars(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public static synchronized Mars getInstance(int xAxis, int yAxis) {
        if (instance == null) {
            instance = new Mars(xAxis, yAxis);
        }
        return instance;
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }
}
