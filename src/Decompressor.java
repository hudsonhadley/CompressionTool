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
    private int startOfText;
    private int endOfText;

    /**
     * Constructs a decompressor based on the input text
     * @param input the compressed byte[] we wish to decompress
     * @throws IllegalArgumentException if an empty String is passed
     */
    public Decompressor(byte[] input) throws IllegalArgumentException {
        if (input.length == 0)
            throw new IllegalArgumentException("No input to decompress");
        bytes = Main.bytesToString(input);

        frequencyTable = getFrequencyTable();
        huffmanBinaryTree = new HuffmanBinaryTree(frequencyTable);
        prefixCodeTable = new PrefixCodeTable(huffmanBinaryTree);

        // getFrequencyTable found the start of the text, but we also need to find the end (some bits were tacked on
        // so that we could pack into bytes)
        char lastBit = bytes.charAt(bytes.length() - 1);
        int i = bytes.length() - 1;
        // The tacked on bits will all be the same as the last one, so keep going until you find one that is different
        while (bytes.charAt(i) == lastBit)
            i -= 1;

        endOfText = i + 1;
    }

    /**
     * Decompresses the byte[] into a String
     * @return the decompressed String
     */
    public String decompress() {
        String text = bytes.substring(startOfText, endOfText);
        StringBuilder decompressedTextBuilder = new StringBuilder();

        // When parsing through the text, we need a start and an end. The length of each code varies so we cannot look
        // in a specific range. We will start at one character. If nothing is found, we move on to two, and so on. When
        // we do find a code, the end becomes the start of the next one and we repeat until the end of the file.
        int start = 0;
        int end = 1;

        // Go through the bits and find the codes
        while (start < text.length()) {

            // This will continue until we successfully find a code and can break
            while (true) {
                try {
                    // Will throw IllegalArgumentException if code not found
                    char c = prefixCodeTable.getChar(text.substring(start, end));

                    // Will only reach these two lines if it successfully finds a code
                    decompressedTextBuilder.append(c);
                    break;
                } catch (IllegalArgumentException iae) {
                    end += 1; // If we can't find a code, increase our range
                }
            }
            start = end; // Start becomes the end and we keep looking for other codes
            end = start + 1;
        }

        return decompressedTextBuilder.toString();
    }

    /**
     * @return the frequency table that is encoded in the header of the byte[]
     */
    private FrequencyTable getFrequencyTable() {
        ArrayList<Character> characters = new ArrayList<>();
        ArrayList<Integer> frequencies = new ArrayList<>();

        // In the string, 0-7 is the frequency length, 8-15 is the first character,
        // and 16-(16+frequency length) is the first frequency
        int frequencyLength = Main.stringToByte(bytes.substring(0, 8));
        characters.add((char) Main.stringToByte(bytes.substring(8,16))); // Add the first character
        frequencies.add((int) Main.stringToByte(bytes.substring(16,16 + frequencyLength))); // Add the first frequency

        // Parse through one after the first frequency until we find the first character again (then we stop)
        int i = 16 + frequencyLength;

        // We use a while (true) with a break since it is bulky to compute the value of the character several times
        // per loop. This way we only need to do it once per time through and we can just break if we hit it
        while (true) {
            // the first 8 is the character, and the next 'frequencyLength' bits are the frequency
            char c = (char) Main.stringToByte(bytes.substring(i, i + 8));
            // If the character is the same as the first one, we have reached the end of the frequency table
            if (c == characters.get(0)) {
                startOfText = i + 8; // the text will start after the second occurrence of the first character
                break;
            }

            int f = (int) Main.stringToByte(bytes.substring(i + 8, i + 8 + frequencyLength));

            characters.add(c);
            frequencies.add(f);

            i += 8 + frequencyLength;
        }

        return new FrequencyTable(characters, frequencies);
    }
}
