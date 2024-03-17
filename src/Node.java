/**
 * A general Node of a binary tree. Each node has two children (these may be null) and a weight.
 * @author Hudson Hadley
 */
public class Node {
    protected int weight;
    protected Node left;
    protected Node right;

    /**
     * Constructor setting each member variable
     * @param weight the weight of the node
     * @param left the left neighbor of the node
     * @param right the right neighbor of the node
     */
    public Node(int weight, Node left, Node right) {
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    /**
     * Creates a semi-deep copy of a Node. Semi-deep meaning that the weight is a deep copy, but it merely references
     * to the left and to the right.
     * @param other the Node we want to copy
     */
    public Node(Node other) {
        this.weight = other.weight;
        this.left = other.left;
        this.right = other.right;
    }

    public int getWeight() {
        return weight;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
