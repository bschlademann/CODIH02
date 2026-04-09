package Uebung_2_1;

public class Main {
    void main() {
        Circle circle = new Circle();
        circle.center = new Point();
        double x = circle.center.x;
        double y = circle.center.y;
        double radius = circle.radius;
        x = 1;
        y = 2;
        radius = 2.5;

        IO.println("x: " + x + ", y: " + y + ", radius: " + radius);
    }
}