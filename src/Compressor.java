import java.sql.SQLOutput;
import java.util.Arrays;

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
    private String text;

    /**
     * Constructs a compressor based on an input
     * @param input the string we want to compress
     * @throws IllegalArgumentException if an empty string is passed
     */
    public Compressor(String input) throws IllegalArgumentException {
        if (input.isEmpty())
            throw new IllegalArgumentException("String is empty");
        frequencyTable = new FrequencyTable(input);
        huffmanBinaryTree = new HuffmanBinaryTree(frequencyTable);
        prefixCodeTable = new PrefixCodeTable(huffmanBinaryTree);
        text = input;
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
     * <br>
     * Headers also contain a separator so the decompressor knows when to start translating back. The indicator of this
     * will be the first character in binary again.
     * @return a binary header storing the frequency table
     */
    private String getHeader() {
        StringBuilder headerBuilder = new StringBuilder();

        // We first need to determine how many bits are going to be used to store each frequency
        // (This cannot simply be a byte since frequencies will often exceed 2^8 for large text files)

        // The amount of bits it takes to store the greatest frequency is the amount of bits we will use
        // to store each frequency
        int maxFrequency = frequencyTable.getMaxFrequency();
        int frequencyLength = Integer.toBinaryString(maxFrequency).length();
        // This length will be the first thing in the file corresponding to the first byte
        headerBuilder.append(Main.makeByteString(frequencyLength));


        for (int i = 0; i < frequencyTable.getSize(); i++) {
            headerBuilder.append(Main.makeByteString(frequencyTable.getChar(i))); // chars are ints in reality
            headerBuilder.append(Main.makeBitString(frequencyTable.getFrequency(i), frequencyLength));
        }

        // Create a separator
        headerBuilder.append(Main.makeByteString(frequencyTable.getChar(0)));

        return headerBuilder.toString();
    }


    /**
     * Gives the bit string representation of the text. Compressed strings have two parts: the header and the text. The header is found by getHeader(). The text is
     * found by substituting each character in the original input for its code.
     * @return the compressed string
     * @see Compressor#getHeader()
     */
    private String getBitString() {
        StringBuilder compressedStringBuilder = new StringBuilder();
        compressedStringBuilder.append(getHeader());

        // Go through every character in the text and replace each in the string builder
        for (int i = 0; i < text.length(); i++) {
            // We did not keep track if the characters that cannot be packed into a byte
            if (Integer.toBinaryString(text.charAt(i)).length() <= 8)
                compressedStringBuilder.append(prefixCodeTable.getCode(text.charAt(i)));
        }

        // The bit string has to be divisible by 8, so we will add the opposite of the last bit until we reach that
        char addOn = compressedStringBuilder.charAt(compressedStringBuilder.length() - 1) == '0' ? '1' : '0';

        // If the compressed string is already at 8, we need to add something on so the decompressor knows not to erase
        // part of the file
        compressedStringBuilder.append(addOn);
        while (compressedStringBuilder.length() % 8 != 0)
            compressedStringBuilder.append(addOn);

        return compressedStringBuilder.toString();
    }

    /**
     * Converts the given text into a byte array
     * @return the compressed byte array
     */
    public byte[] compress() {
        String bitString = getBitString();

        byte[] bytes = new byte[bitString.length() / 8];

        for (int i = 0; i < bytes.length; i++) {
            String substring = bitString.substring(i * 8, i * 8 + 8);
            bytes[i] = Main.stringToByte(substring);
        }

        return bytes;
    }
}