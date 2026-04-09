package Uebung_2_4;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    void main() {
//        Scanner scanner = new Scanner(System.in);
//        IO.print("circle x: ");
//        double x = scanner.nextDouble();
//        IO.print("circle y: ");
//        double y = scanner.nextDouble();
//        IO.print("circle radius: ");
//        double radius = scanner.nextDouble();
//        Circle circleCustom = new Circle(x, y, radius);
//        Circle circleDefault = new Circle();
//
//        double xCustom = circleCustom.getCenter().getX();
//        double yCustom = circleCustom.getCenter().getY();
//        double radiusCustom = circleCustom.getRadius();
//
//        double xDefault = circleDefault.getCenter().getX();
//        double yDefault = circleDefault.getCenter().getY();
//        double radiusDefault = circleDefault.getRadius();

//        System.out.printf("""
//                custom circle:
//                x:      %.2f
//                y:      %.2f
//                radius: %.2f
//
//                default circle:
//                x:      %.2f
//                y:      %.2f
//                radius: %.2f
//                """, xCustom, yCustom, radiusCustom, xDefault, yDefault, radiusDefault);

        Circle[] circles = createCircles(3);
        moveCircles(circles, 2, 1);
        Circle maxRadiusCircle = Circle.maxRadius(circles);
        System.out.printf("""
        x:      %.2f
        y:      %.2f
        radius: %.2f
        area:   %.2f
        """,
                maxRadiusCircle.getCenter().getX(),
                maxRadiusCircle.getCenter().getY(),
                maxRadiusCircle.getRadius(),
                maxRadiusCircle.area()
        );
    }

    private int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private Circle[] createCircles(int n) {
        Circle[] circles = new Circle[n];
        for (int i = 0; i < n; i++) {
            int radius = getRandomNumber(1, 5);
            double x = getRandomNumber(-10, 10);
            double y = getRandomNumber(-10, 10);
            circles[i] = new Circle(x, y, radius);
        }
        return circles;
    }

    private void moveCircles(Circle[] circles, int x, int y) {
        for (Circle circle : circles) {
            circle.move(2,1);
        }
    }
}

