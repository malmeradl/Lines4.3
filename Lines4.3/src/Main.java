import java.util.*;

public class Main {
    public static void main(String[] args) {
        FileBin f = new FileBin("file.bin");
        System.out.println(f.points.toString());

        f.addPoint(1, 1);
        f.addPoint(1, 2);
        f.addPoint(2, 2);
        f.addPoint(3, 1);
        //f.writeInFile();
        System.out.println(f.points.toString());
        Set<Line> lines = new TreeSet<>(new LineComparator());
        Line line;
        for (Point i : f.points) {
            for (Point j : f.points) {
                if (!Point.isEquals(i, j)) {
                    line = new Line(i, j);
                    System.out.println(i + " " + j);
                    lines.add(line);
                }
            }

        }
        Main.printSet(lines);
    }

    static <T> void printSet(Set<T> set) {
        for (T i : set) {
            System.out.println(i);
        }
    }
}