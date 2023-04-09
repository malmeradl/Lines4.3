import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Line {
    double A;
    double B;
    double C;

    Line(Point p1, Point p2) {
        this.A = p2.y - p1.y;
        this.B = p1.x - p2.x;
        this.C = p2.x * p1.y - p1.x * p2.y;

    }

    @Override
    public String toString() {
        return String.format("%,.3f*x + %,.3f*y + %,.3f = 0", A, B, C);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Line line2)) {
            return false;
        } else {
            if (this.B == 0 && line2.B == 0 && Double.compare(this.A / line2.A, this.C / line2.C) == 0) {//если B равны 0
                return true;
            } else if (this.A / this.B != line2.A / line2.B) {// Проверяем пропорциональность угловых коэффициентов
                return false;
            } else if (this.C / this.B != line2.C / line2.B) {// Проверяем пропорциональность сдвигов
                return false;
            }
            // Если угловые коэффициенты и сдвиги пропорциональны,
            // то прямые считаем равными
            else {
                return true;
            }
        }
    }

    @Override
    public int hashCode() {
        if (this.A == 0 && this.B != 0 && this.C == 0) {
            return ((int) (this.B * 23));
        }
        if (this.A == 0 && this.B != 0 && this.C != 0) {
            return ((int) (this.B / this.C * 61));
        }
        if (this.A != 0 && this.B == 0 && this.C == 0) {
            return ((int) (this.A * 19));
        }
        if (this.A != 0 && this.B == 0 && this.C != 0) {
            return ((int) (this.A / this.C * 31));
        }
        if (this.A != 0 && this.B != 0 && this.C == 0) {
            return ((int) (this.A / this.B * 51));
        }
        return ((int) (A / B * 57));
    }
    static Set<Line> getLinesByPoints(List<Point> points) {
        Set<Line> lines = new HashSet<>();
        for (Point i : points) {
            for (Point j : points) {
                if (!Point.isEquals(i, j)) {
                    lines.add(new Line(i, j));
                }
            }
        }
        return lines;
    }
}
