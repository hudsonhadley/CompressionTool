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
    private ArrayList<String> codes;

    /**
     * Constructs a PrefixCodeTable based on data stored in a Huffman binary tree
     * @param huffmanBinaryTree the tree containing each character we want to encode
     * @see HuffmanBinaryTree
     */
    public PrefixCodeTable(HuffmanBinaryTree huffmanBinaryTree) {

    }

    /**
     * @param c the character we want to look up
     * @return the encoding of the character
     * @throws IllegalArgumentException if the character is not found
     */
    public String getCode(char c) throws IllegalArgumentException {
        int index = characters.indexOf(c);

        if (index == -1)
            throw new IllegalArgumentException("Character not found");

        return codes.get(index);
    }
}
