import java.util.ArrayList;

/**
 * This represents a Huffman binary tree. These are generally used when it comes to Huffman encoding/decoding and refers
 * to how frequently a certain characters appears in a string of text. Each node is either an internal node or a leaf.
 * Internal nodes do not have a value, but only a weight. These always have children. Leafs have both a weight and a
 * value. These never have children.
 * @see HuffmanLeaf
 * @see HuffmanInternalNode
 * @author Hudson Hadley
 */
public class HuffmanBinaryTree {
    /**
     * The root of the binary tree
     */
    private Node root;

    /**
     * Constructs a new HuffmanBinaryTree with knowledge of the value and weight of the root (this is a HuffmanLeaf)
     * @param value the value we want to assign (refers to a character)
     * @param weight the weight we want to assign (refers to frequency)
     */
    public HuffmanBinaryTree(char value, int weight) {
        this.root = new HuffmanLeaf(value, weight);
    }

    /**
     * Constructs a new HuffmanBinaryTree based off of a frequency table
     * @param ft the frequency we want to draw from
     */
    public HuffmanBinaryTree(FrequencyTable ft) {

    }

    /**
     * Sorts a collection of HuffmanBinaryTrees based on the root weight from lowest to highest
     * @param hbt the array list of Huffman binary trees we want to sort
     */
    public static void sort(ArrayList<HuffmanBinaryTree> hbt) {

    }
}
