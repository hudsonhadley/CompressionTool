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

    }

    /**
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