package Uebung_2_3;

import java.util.Scanner;

public class Main {
    void main() {
        Scanner scanner = new Scanner(System.in);
        IO.print("circle x: ");
        double x = scanner.nextDouble();
        IO.print("circle y: ");
        double y = scanner.nextDouble();
        IO.print("circle radius: ");
        double radius = scanner.nextDouble();
        scanner.close();

        Circle circleCustom = new Circle(x, y, radius);
        Circle circleDefault = new Circle();

        double xCustom = circleCustom.getCenter().getX();
        double yCustom = circleCustom.getCenter().getY();
        double radiusCustom = circleCustom.getRadius();

        double xDefault = circleDefault.getCenter().getX();
        double yDefault = circleDefault.getCenter().getY();
        double radiusDefault = circleDefault.getRadius();

        System.out.printf("""
                custom circle:
                x:      %.2f
                y:      %.2f
                radius: %.2f
                
                default circle:
                x:      %.2f
                y:      %.2f
                radius: %.2f
                """, xCustom, yCustom, radiusCustom, xDefault, yDefault, radiusDefault);
    }
}

