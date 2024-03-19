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

        for (int i = 0; i < frequencyTable.getSize(); i++) {
            headerBuilder.append(makeByte(frequencyTable.getChar(i))); // chars are ints in reality
            headerBuilder.append(makeByte(frequencyTable.getFrequency(i)));
        }

        // Create a separator
        headerBuilder.append(makeByte(frequencyTable.getChar(0)));

        return headerBuilder.toString();
    }

    /**
     * Converts an integer into a byte
     * @param i an integer we want to convert
     * @return the integer i in byte form
     */
    private String makeByte(int i) {
        StringBuilder byteBuilder = new StringBuilder();
        byteBuilder.append(Integer.toBinaryString(i));

        while (byteBuilder.length() < 8)
            byteBuilder.insert(0, "0");

        return byteBuilder.toString();
    }

    /**
     * Gives the bit string representation of the text. Compressed strings have two parts: the header and the text. The header is found by getHeader(). The text is
     * found by substituting each character in the original input for its code.
     * @return the compressed string
     * @see Compressor#getHeader()
     */
    public String getBitString() {
        StringBuilder compressedStringBuilder = new StringBuilder();
        compressedStringBuilder.append(getHeader());

        // Go through every character in the text and replace each in the string builder
        for (int i = 0; i < text.length(); i++) {
            compressedStringBuilder.append(prefixCodeTable.getCode(text.charAt(i)));
        }

        return compressedStringBuilder.toString();
    }
}