import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FrequencyTableTest {
    @Test
    public void makeTableTest() {
        FrequencyTable ft = new FrequencyTable();
        // Assert that when we try to access it, it fails
        assertThrows(IndexOutOfBoundsException.class,
                () -> ft.getFrequency(0));
    }

    @Test
    public void makeTableFromStringTest() {
        FrequencyTable ft = new FrequencyTable("abcdabcd");

        assertTrue(ft.getFrequency('a') == 2);
        assertTrue(ft.getFrequency(1) == 2);
    }

    @Test
    public void addToTableTest() {
        FrequencyTable ft = new FrequencyTable("-1");
        ft.add('-');
        assertTrue(ft.getFrequency('-') == 2);
    }

    @Test
    public void toStringTest() {
        FrequencyTable ft = new FrequencyTable("jaljf");

        String expected = "j: 2\n" +
                          "a: 1\n" +
                          "l: 1\n" +
                          "f: 1\n";

        assertTrue(ft.toString().equals(expected));
    }
}
