import java.util.ArrayList;
import java.util.Collections;

/**
 * This represents a Huffman binary tree. These are generally used when it comes to Huffman encoding/decoding and refers
 * to how frequently a certain characters appears in a string of text. Each node is either an internal node or a leaf.
 * Internal nodes do not have a value, but only a weight. These always have children. Leafs have both a weight and a
 * value. These never have children. Additionally, the HuffmanBinaryTree implements the Comparable interface. This is
 * so that when we compare two HuffmanBinaryTrees, they are compared based on the weight of the root node.
 * @see HuffmanLeaf
 * @see HuffmanInternalNode
 * @author Hudson Hadley
 */
public class HuffmanBinaryTree implements Comparable<HuffmanBinaryTree> {
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
     * @param ft the frequency table we want to draw from
     */
    public HuffmanBinaryTree(FrequencyTable ft) {
        // To begin with we will store a list of trees
        ArrayList<HuffmanBinaryTree> binaryTreeArrayList = new ArrayList<>();

        // Each tree will only have one node corresponding to an element in the frequency table
        for (int i = 0; i < ft.getSize(); i++) {
            HuffmanBinaryTree hbt = new HuffmanBinaryTree(ft.getChar(i), ft.getFrequency(i));
            binaryTreeArrayList.add(hbt);
        }

        // We need to continue sorting and merging until we only have one tree left
        while (binaryTreeArrayList.size() > 1) {
            Collections.sort(binaryTreeArrayList);
            // We will be deleting a lot of things. It will be more efficient to delete from the end than from the front
            Collections.reverse(binaryTreeArrayList);

            binaryTreeArrayList.get(binaryTreeArrayList.size() - 2).merge(
                    binaryTreeArrayList.get(binaryTreeArrayList.size() - 1)
            );

            // Remove the last index
            binaryTreeArrayList.remove(binaryTreeArrayList.size() - 1);
        }

        this.root = binaryTreeArrayList.get(0).root;
    }

    /**
     * Merges two Huffman binary trees by adding the two weights of the root nodes together to make a different root
     * node. The two trees then become nodes of this root
     * @param other the other Huffman binary tree we want to merge with
     */
    private void merge(HuffmanBinaryTree other) {
        HuffmanInternalNode root = new HuffmanInternalNode(
                this.getRootWeight() + other.getRootWeight(),
                other.getRoot(),
                this.getRoot()

        );
        setRoot(root);
    }

    /**
     * @return the weight of the root node
     */
    public int getRootWeight() {
        return root.weight;
    }

    /**
     * @return the root node
     */
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * Compares the current HuffmanBinaryTree to another HuffmanBinaryTree based on the weight of the root node.
     * @param hbt the object to be compared.
     * @return this.getRootWeight() - hbt.getRootWeight()
     */
    @Override
    public int compareTo(HuffmanBinaryTree hbt) {
        return Integer.compare(this.getRootWeight(), hbt.getRootWeight());
    }
}
