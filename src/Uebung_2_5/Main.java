package Uebung_2_5;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    void main() {
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

