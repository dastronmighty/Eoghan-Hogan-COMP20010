package Point2D;

import java.util.Random;

public class Point2D {
    private double x, y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double distanceTo(Point2D that) {
        return Math.sqrt((Math.pow(((that.x - x)), 2) + Math.pow(((that.y - y)), 2)));
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public static void main(String[] args) {

        Random rand = new Random();

        Point2D p1, p2;
        for (double i = 10; i < 10001; i *= 10) {
            int amtPoints = (int) i;
            System.out.print("the avaerage distance of " + amtPoints + "\t random points is ");
            double total = 0;
            for (int j = 0; j < amtPoints; j++) {
                p1 = new Point2D(rand.nextDouble(), rand.nextDouble());
                p2 = new Point2D(rand.nextDouble(), rand.nextDouble());
                total += p2.distanceTo(p1);
            }
            System.out.println(total / amtPoints);
        }

    }
}