package Uebung_2_2;

import java.util.Scanner;

public class Main {
    void main() {
        Scanner scanner = new Scanner(System.in);
        IO.print("circle x: ");
        double inputX = scanner.nextDouble();
        IO.print("circle y: ");
        double inputY = scanner.nextDouble();
        Circle circle = createCircle(inputX, inputY);

        Point center = circle.getCenter();
        double centerX = center.getX();
        double centerY = center.getY();
        IO.println("x:" + centerX + ", y: " + centerY);
    }

    Circle createCircle(double x, double y) {
        Circle circle = new Circle();
        Point center = new Point();
        circle.setCenter(center);
        center.setX(x);
        center.setY(y);
        return circle;
    }
}

