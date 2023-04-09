import java.util.*;

public class Main {
    public static void main(String[] args) {
        FileBin f = new FileBin("file.bin");
        System.out.println(f.points.toString());

        f.addPoint(1, 1);

        f.writeInFile();
        System.out.println(f.points.toString());
        Set<Line> lines = new HashSet<Line>();
        for (Point i : f.points) {
            for (Point j : f.points) {
                if (!Point.isEquals(i, j)) {
                    lines.add(new Line(i, j));
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