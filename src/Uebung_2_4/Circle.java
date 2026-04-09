package Uebung_2_4;

public class Circle {
    private Point center;
    private double radius;
    final private double pi = 3.1415926;

    public Circle(double x, double y, double radius) {
        this.center = new Point(x, y);
        this.radius = radius < 1 ? 1 : radius;
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

    public void move(int x, int y) {
        this.center.move(x, y);
    }

    public double circum() {
        return 2 * this.pi * this.radius;
    }

    public double area() {
        return this.pi * this.radius * this.radius;
    }

    public static Circle maxRadius(Circle[] circles) {
        double maxRadius = 0;
        Circle maxCircle = null;
        for (int i = 0; i < circles.length; i++) {
            Circle currentCircle = circles[i];
            double currentRadius = currentCircle.getRadius();
            if (currentRadius > maxRadius) {
                maxRadius = currentRadius;
                maxCircle = currentCircle;
            }
        }
        return maxCircle;
    }
}
