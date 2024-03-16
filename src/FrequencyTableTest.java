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
}
