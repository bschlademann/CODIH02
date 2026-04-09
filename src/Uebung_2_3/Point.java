package Uebung_2_3;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }
}
