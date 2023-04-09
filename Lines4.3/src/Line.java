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

   static boolean isThreeNulls(Line line) {
       return line.A == 0 && line.B == 0 && line.C == 0;
   }
}
