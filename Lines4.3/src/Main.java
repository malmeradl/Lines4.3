import java.util.*;

public class Main {
    static Scanner in;

    public static void main(String[] args) {

        FileBin file = new FileBin("file.bin");
        in = new Scanner(System.in);
        Set<Line> lines;

        System.out.println("Enter the commands: ");
        System.out.println("0 - exit");
        System.out.println("1 - print points from the bin file");
        System.out.println("2 - add point");
        System.out.println("3 - delete point by index");
        System.out.println("4 - print lines ");

        System.out.print("\nInput: ");
        int choice = in.nextInt();

        while (choice != 0) {

            switch (choice) {
                case 0 -> {
                    System.out.println("Exit.");
                }
                case 1 -> {
                    file.readFromFile();
                    System.out.println(file.points.toString());
                }
                case 2 -> {
                    System.out.println("input x and y for point: ");
                    file.addPoint(in.nextDouble(), in.nextDouble());
                }
                case 3 -> {
                    System.out.print("Index of the point to be deleted: ");
                    file.deletePointByIndex(in.nextInt());
                }
                case 4 -> {
                    lines = Main.getLinesByPoints(file.points);
                    Main.printSet(lines);
                }
                default -> {
                    System.out.println("No such command.");
                }
            }
            System.out.print("\nInput: ");
            choice = in.nextInt();
        }
        in.close();
    }

    static <T> void printSet(Set<T> set) {
        for (T i : set) {
            System.out.println(i);
        }
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