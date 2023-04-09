import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    @Test
    public void testEquals() {
        Line line1 = new Line(new Point(2,1),new Point(2,1));
        Line line2 = new Line(new Point(2,1),new Point(2,1));
        assertTrue(line1.equals(line2));

        Line line3 = new Line(new Point(9,1),new Point(5,4));
        Line line4 = new Line(new Point(2,1),new Point(2,1));
        assertFalse(line3.equals(line4));
    }
}