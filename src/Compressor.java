/**
 * The Compressor class is used to compress a String or file. It uses a frequency
 * table in conjunction with a Huffman binary tree and a prefix code table to
 * substitute each character with a code. This substitution is put in an output
 * file or printed out along with a header that states which codes reference
 * which characters.
 * @see FrequencyTable
 * @see HuffmanBinaryTree
 * @see PrefixCodeTable
 * @author Hudson Hadley
 */
public class Compressor {
    private FrequencyTable frequencyTable;
    private HuffmanBinaryTree huffmanBinaryTree;
    private PrefixCodeTable prefixCodeTable;

    /**
     * Constructs a compressor based on an input
     * @param input the string we want to compress
     */
    public Compressor(String input) {
        frequencyTable = new FrequencyTable(input);
        huffmanBinaryTree = new HuffmanBinaryTree(frequencyTable);
        prefixCodeTable = new PrefixCodeTable(huffmanBinaryTree);
    }

    /**
     * This method converts the frequency table into a binary string.
     * It should be noted that it does not just convert frequencyTable.toString() into binary. This would cause lots
     * of useless text to be in our compressed file (which defeats the purpose). Instead, each element of the table
     * has the character in binary, then the frequency in binary back to back. We tell the difference since each
     * character/frequency is a byte long (8 bits).
     * <br>
     * <br>
     * An example of this would be if 'a' occurred 28 times, we would have:
     * <br>
     * 0110000100011100
     * @return a binary header storing the frequency table
     */
    private String getHeader() {
        return "";
    }

    /**
     * @return the compressed string
     */
    public String compress() {
        return "";
    }
}