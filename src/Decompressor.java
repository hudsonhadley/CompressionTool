import java.beans.FeatureDescriptor;

/**
 * The Decompressor class is used to decompress a file or String. The file must be compressed by the Compressor class
 * in order for it to have a correct decompression. In theory, it can 'decompress' any file (regardless if it is a
 * compressed file), but in general, it ought to be used in conjunction with the Compressor class. Just as the
 * Compressor called on FrequencyTable, HuffmanBinaryTree, and PrefixCodeTable to compress, this class calls on those
 * same classes for the reverse.
 * @see Compressor
 * @see FrequencyTable
 * @see HuffmanBinaryTree
 * @see PrefixCodeTable
 * @author Hudson Hadley
 */
public class Decompressor {
    private FrequencyTable frequencyTable;
    private HuffmanBinaryTree huffmanBinaryTree;
    private PrefixCodeTable prefixCodeTable;
    private byte[] bytes;

    /**
     * Constructs a decompressor based on the input text
     * @param input the compressed byte[] we wish to decompress
     * @throws IllegalArgumentException if an empty String is passed
     */
    public Decompressor(byte[] input) throws IllegalArgumentException{
        // TODO finish method
    }

    /**
     * Decompresses the byte[] into a String
     * @return the decompressed String
     */
    public String decompress() {
        return ""; // TODO finish method
    }

    /**
     * @return the frequency table that is encoded in the header of the byte[]
     */
    private FrequencyTable getFrequencyTable() {
        return new FrequencyTable(); //TODO finish method
    }
}
