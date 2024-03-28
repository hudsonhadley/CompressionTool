import java.beans.FeatureDescriptor;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

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
    private String bytes;

    /**
     * Constructs a decompressor based on the input text
     * @param input the compressed byte[] we wish to decompress
     * @throws IllegalArgumentException if an empty String is passed
     */
    public Decompressor(byte[] input) throws IllegalArgumentException {
        bytes = Main.bytesToString(input);
        System.out.println(bytes);

        frequencyTable = getFrequencyTable();
//        System.out.println(frequencyTable.getFrequency('X'));
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
        ArrayList<Character> characters = new ArrayList<>();
        ArrayList<Integer> frequencies = new ArrayList<>();

        return new FrequencyTable(characters, frequencies);
    }
}
