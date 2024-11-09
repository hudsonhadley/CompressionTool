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
        characters = new ArrayList<>();
        codes = new ArrayList<>();
        Node root = huffmanBinaryTree.getRoot();
        // If in our binary tree the root is a leaf, there is only one character
        if (root.isExternal()) {
            // Since there's only one character we can just declare the code to be "0"
            characters.add(root.getValue());
            codes.add("0");
        } else { // If the tree is more extensive
            generateCodes("", huffmanBinaryTree.getRoot());
        }
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
        // If it is a leaf, we want to add the character and code
        if (node.isExternal()) {
            characters.add(node.getValue());
            codes.add(currentCode);
        } else { // If it is not a leaf, all we care about are its children
            generateCodes(currentCode + "0", node.getLeft());
            generateCodes(currentCode + "1", node.getRight());
        }
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

    /**
     * @param code the code of the character we want to look up
     * @return the character with the correct code
     * @throws IllegalArgumentException if the code is not found
     */
    public char getChar(String code) throws IllegalArgumentException {
        int index = codes.indexOf(code);

        // If we cannot find the code
        if (index == -1)
            throw new IllegalArgumentException("Code not found");

        return characters.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < characters.size(); i++) {
            stringBuilder.append(characters.get(i));
            stringBuilder.append(": ");
            stringBuilder.append(codes.get(i));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
