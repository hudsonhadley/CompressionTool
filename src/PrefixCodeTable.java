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
        generateCodes("", huffmanBinaryTree.getRoot());
    }

    /**
     * Traverses through a current node using recursion and generates codes for each node.
     * Only leaves are added to the characters and codes lists, but there does exist a code for each node.
     * Starting with the currentCode, if we take a left we add a 0 to the beginning, and if we take a right
     * we add a 1 to the beginning.
     * @param currentCode the code we have at the current node. If it is the first time calling, it will be ""
     * @param node the current node we are at
     */
    private void generateCodes(String currentCode, Node node) {

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
