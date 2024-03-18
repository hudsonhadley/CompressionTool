import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrefixCodeTableTest {
    @Test
    public void oneCharacterTest() {
        FrequencyTable ft = new FrequencyTable("a");
        HuffmanBinaryTree hbt = new HuffmanBinaryTree(ft);
        PrefixCodeTable pct = new PrefixCodeTable(hbt);

        assertThrows(IllegalArgumentException.class,
                () -> pct.getCode(' '));
        assertEquals("0", pct.getCode('a'));
    }

    @Test
    public void twoCharacterTest() {
        FrequencyTable ft = new FrequencyTable("AbAbb");
        HuffmanBinaryTree hbt = new HuffmanBinaryTree(ft);
        PrefixCodeTable pct = new PrefixCodeTable(hbt);

        assertThrows(IllegalArgumentException.class,
                () -> pct.getCode('a'));
        assertEquals("0", pct.getCode('A'));
        assertEquals("1", pct.getCode('b'));
    }

    @Test
    public void manyCharacterTest() {
        FrequencyTable ft = new FrequencyTable("dCACbdbCdd");
        HuffmanBinaryTree hbt = new HuffmanBinaryTree(ft);
        PrefixCodeTable pct = new PrefixCodeTable(hbt);

        assertThrows(IllegalArgumentException.class,
                () -> pct.getCode('\"'));
        assertEquals("0", pct.getCode('d'));
        assertEquals("110", pct.getCode('A'));
        assertEquals("111", pct.getCode('b'));
        assertEquals("10", pct.getCode('C'));
    }
}
