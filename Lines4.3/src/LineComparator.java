import java.util.Comparator;

public class LineComparator implements Comparator<Line> {
    @Override
    public int compare(Line line1, Line line2) {
        System.out.println(line1.toString());
        System.out.println(line2.toString());

        if (line1.B == 0 && line2.B == 0 && Double.compare(line1.A / line2.A, line1.C / line2.C) == 0) {
            System.out.println("--------одинаковые---------");
            return 0;
        } else if (line1.A / line1.B != line2.A / line2.B) {// Проверяем пропорциональность угловых коэффициентов
            System.out.println("ваще разные");
            return Double.compare(line1.A / line1.B, line2.A / line2.B);
        } else if (line1.C / line1.B != line2.C / line2.B) {// Проверяем пропорциональность сдвигов
            System.out.println("сдвиг");
            return Double.compare(line1.C / line1.B, line2.C / line2.B);
        }
        // Если угловые коэффициенты и сдвиги пропорциональны,
        // то прямые считаем равными
        else {
            System.out.println("одинаковые");
            return 0;
        }
    }
}