import java.io.*;
import java.util.*;

public class FileBin implements Serializable {
    List<Point> points;
    String filePath;

    FileBin(String file) {
        this.filePath = file;
        readFromFile();
    }

    @SuppressWarnings("unchecked")
    void readFromFile() {
        try {
            InputStream is = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(is);
            points = (List<Point>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            points = new ArrayList<>();
        }
    }

    void addPoint(double x, double y) {
        points.add(new Point(x, y));
        writeInFile();
    }


    void writeInFile() {
        try {
            OutputStream os = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(points);
            oos.close();
            System.out.println("...saving...");
        } catch (IOException e) {
            System.err.println("I can't save the file.");
        }
    }

    void deletePointByIndex(int index) {
        if (points.size() < index) {
            System.err.println("No such index in List.");
        } else {
            points.remove(index);
        }
        writeInFile();
    }

}
