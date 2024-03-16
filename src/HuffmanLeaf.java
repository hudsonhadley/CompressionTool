/**
 * This represents a leaf in a Huffman binary tree. Leaves have weights and values and no children. The weights are
 * generally the frequencies of a specific character, which is in turn the value. Leaves are a child class of Node. The
 * main difference between a leaf and any other node is that leaves may not have children. As such, these are set to
 * null.
 * @see HuffmanInternalNode
 * @see HuffmanBinaryTree
 * @see Node
 * @author Hudson Hadley
 */
public class HuffmanLeaf extends Node {
    /**
     * The value is the character the node refers to
     */
    private char value;

    public HuffmanLeaf(char value, int weight) {
        super(weight, null, null); // Leaves cannot have neighbors

        this.value = value;
    }
}
