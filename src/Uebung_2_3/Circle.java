package Uebung_2_3;

public class Circle {
    private Point center;
    private double radius;

    public Circle(double x, double y, double radius) {
        this.center = new Point(x, y);
        this.radius = radius < 0 ? 0 : radius;
    }

    public Circle() {
        this.center = new Point(0, 0);
        this.radius = 1;
    }

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }
}
