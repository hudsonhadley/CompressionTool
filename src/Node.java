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
