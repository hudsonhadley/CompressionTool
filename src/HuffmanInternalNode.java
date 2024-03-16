/**
 * This represents an internal node in a Huffman binary tree. Internal nodes always have children which may either
 * be leaves or other internal nodes. As such the internal nodes are also a child class of the Node class.
 * @see HuffmanBinaryTree
 * @see HuffmanLeaf
 * @see Node
 * @author Hudson Hadley
 */
public class HuffmanInternalNode extends Node {
    /**
     * Constructs an internal node
     * @param weight the weight we want to assign
     * @param left the left neighbor
     * @param right the right neighbor
     * @throws IllegalArgumentException if the left or right neighbor is null
     */
    public HuffmanInternalNode(int weight, Node left, Node right) throws IllegalArgumentException {
        super(weight, left, right);

        if (left == null || right == null)
            throw new IllegalArgumentException("Internal nodes must have children");
    }
}
