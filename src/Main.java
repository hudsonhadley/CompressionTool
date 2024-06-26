import java.io.*;
import java.util.Scanner;

public class Main {
    /**
     * Converts a string of 0s and 1s into an actual byte
     * @param s a string of 0s and 1s we want to convert
     * @return the byte that s represents
     * @throws IllegalArgumentException if s is greater than 8 long or has something other than a 0 or 1
     */
    public static byte stringToByte(String s) throws IllegalArgumentException {
        if (s.length() > 8)
            throw new IllegalArgumentException("String must be 8 long");

        StringBuilder byteBuilder = new StringBuilder(s);
        while (byteBuilder.length() < 8) {
            byteBuilder.insert(0, '0');
        }
        s = byteBuilder.toString();

        byte b = 0;

        if (s.charAt(0) == '1')
            b = 1;
        else if (s.charAt(0) != '0')
            throw new IllegalArgumentException("String must contain only 0s and 1s");

        for (int i = 1; i < 8; i++) {
            b <<= 1; // shift the bit 1 over (1 -> 10 or 0 -> 00)

            if (s.charAt(i) == '1')
                b += 1;
            else if (s.charAt(i) != '0')
                throw new IllegalArgumentException("String must contain only 0s and 1s");
        }

        return b;
    }

    /**
     * @param bitString a bit string we want to convert to an int
     * @return the corresponding int ("10" -> 2)
     * @throws IllegalArgumentException if bitString has anything other than 0s and 1s
     */
    public static int binaryStringToInt(String bitString) throws IllegalArgumentException {
        int value = 0;

        for (int i = 0; i < bitString.length(); i++) {
            int bit = bitString.charAt(i) - 48; // ascii 48 --> '0'       ascii 49 --> '1'

            value += bit * (int) Math.pow(2, (bitString.length() - 1 - i));
        }

        return value;
    }

    /**
     * @param bytes an array of bytes we want to turn into a string of 0s and 1s
     * @return a String of 0s and 1s representing the bytes array
     */
    public static String bytesToString(byte[] bytes) {
        StringBuilder byteBuilder = new StringBuilder();

        for (byte b: bytes) {
            int num = Byte.toUnsignedInt(b);

            byteBuilder.append(Main.makeByteString(num));
        }
        return byteBuilder.toString();
    }

    /**
     * Converts an integer into a byte string
     * @param i an integer we want to convert
     * @return the integer i in byte form
     * @throws IllegalArgumentException if i is too big
     */
    public static String makeByteString(int i) throws IllegalArgumentException {
        return makeBitString(i, 8);
    }

    /**
     * Converts an integer into a bit string of a certain length
     * @param i the integer we want to convert
     * @param len the length of the bit string we want
     * @return the integer i in bit string form with length len
     * @throws IllegalArgumentException if i is too big to be len long
     */
    public static String makeBitString(int i, int len) throws IllegalArgumentException {
        StringBuilder byteBuilder = new StringBuilder();
        byteBuilder.append(Integer.toBinaryString(i));

        if (byteBuilder.length() > len)
            throw new IllegalArgumentException("i cannot be converted to length " + len);

        while (byteBuilder.length() < len)
            byteBuilder.insert(0, "0");

        return byteBuilder.toString();
    }

    /**
     * Fetches a file we want to parse through.
     * @param fileName the name of the file we want to parse
     * @return a String of the file
     * @throws FileNotFoundException if the file cannot be found
     */
    public static String getFileString(String fileName) throws IOException {
        File inFile = new File(fileName);
        Scanner fileScanner = new Scanner(inFile);
        fileScanner.useDelimiter("");

        StringBuilder stringBuilder = new StringBuilder();

        while (fileScanner.hasNext()) {
            stringBuilder.append(fileScanner.next());
        }

        return stringBuilder.toString();
    }

    /**
     * Fetches a binary file we want to parse through.
     * @param fileName the name of the file we want to parse
     * @return a byte[] of the file
     * @throws IOException if the file cannot be found or if readAllBytes() fails
     */
    public static byte[] getFileBytes(String fileName) throws IOException {
        File inFile = new File(fileName);
        FileInputStream inputStream = new FileInputStream(inFile);

        return inputStream.readAllBytes();
    }

    public static void main(String[] args) throws IOException {
        Scanner inScanner = new Scanner(System.in);

        System.out.print("Enter an input file> ");
        String input = inScanner.nextLine();

        System.out.print("Compressing? (y or n)> ");
        boolean decompressing = inScanner.nextLine().toLowerCase().charAt(0) == 'n';

        System.out.print("Enter an output file> ");
        String output = inScanner.nextLine();


        if (decompressing) {
            byte[] inputBytes = getFileBytes(input);

            Decompressor decompressor = new Decompressor(inputBytes);
            String text = decompressor.decompress();

            PrintWriter printWriter = new PrintWriter(output);
            printWriter.write(text);
            printWriter.close();
        } else {
            // Get the string of the file
            String inputFileString = getFileString(input);

            Compressor compressor = new Compressor(inputFileString);
            byte[] bytes = compressor.compress();

            FileOutputStream outputFile = new FileOutputStream(output);
            outputFile.write(bytes);
            outputFile.close();
        }
    }
}
