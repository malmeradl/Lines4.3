import java.io.Serializable;

public class Point implements Serializable {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return " x(" + x + ") y(" + y + ")";
    }

    static boolean isEquals(Point p1, Point p2) {
        return p1.x == p2.x && p1.y == p2.y;
    }

}
