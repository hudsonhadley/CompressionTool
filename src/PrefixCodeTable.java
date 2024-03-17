import java.util.ArrayList;

/**
 * This class represents a table that encodes binary strings to characters based of the HuffmanBinaryTree
 * @see HuffmanBinaryTree
 * @author Hudson Hadley
 */
public class PrefixCodeTable {
    /**
     * The characters we are encoding
     */
    private ArrayList<Character> characters;
    /**
     * The codes we have encoded for each character
     */
    private ArrayList<Integer> codes;
}
