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
            System.out.println("обькты одинаковы");
            return true;
        }
        if (!(obj instanceof Line)) {
            System.out.println("[ebnf]");
            return false;
        } else {
            Line line2 = (Line) obj;
            System.out.println("---------------------");
            System.out.println(this.toString());
            System.out.println(line2.toString());

            if (this.B == 0 && line2.B == 0 && Double.compare(this.A / line2.A, this.C / line2.C) == 0) {
                System.out.println("--------одинаковые---------");
                return true;
            } else if (this.A / this.B != line2.A / line2.B) {// Проверяем пропорциональность угловых коэффициентов
                System.out.println("ваще разные");
                return false;
            } else if (this.C / this.B != line2.C / line2.B) {// Проверяем пропорциональность сдвигов
                System.out.println("сдвиг");
                return false;
            }
            // Если угловые коэффициенты и сдвиги пропорциональны,
            // то прямые считаем равными
            else {
                System.out.println("одинаковые");
                return true;
            }
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) A;
        result = prime * result + (int) B;
        result = prime * result + (int) C;
        return result;
    }
}
