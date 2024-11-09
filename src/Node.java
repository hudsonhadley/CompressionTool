/**
 * A general Node of a binary tree. Each node has two children (these may be null) and a weight.
 * @author Hudson Hadley
 */
public class Node {
    private int weight;
    private char value;

    private Node left;
    private Node right;

    /**
     * Constructor setting each member variable
     * @param weight the weight of the node
     * @param left the left neighbor of the node
     * @param right the right neighbor of the node
     */
    public Node(char value, int weight, Node left, Node right) {
        this.value = value;
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

    public char getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public boolean isExternal() {
        return left == null && right == null;
    }

    /**
     * @return a String containing the weight of the node
     */
    @Override
    public String toString() {
        return "" + weight;
    }
}
