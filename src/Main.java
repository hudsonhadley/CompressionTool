import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * Fetches a file we want to parse through.
     * @param fileName the name of the file we want to parse
     * @return a String of the file
     * @throws FileNotFoundException if the file cannot be found
     */
    public static String getFileString(String fileName) throws FileNotFoundException{
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
     * The main loop that is executed upon call
     * @param args has the pattern of
     *             <br>
     *             &lt;input&gt; [-d] &lt;output&gt;
     *             <br><br>
     *             &lt;input&gt; - the file we want to compress
     *             <br>
     *             [-d] - if we want to decompress
     *             <br>
     *             &lt;output&gt; - where we want our output to go (default is the input)
     *
     * @throws IOException from FileOutputStream.write(bytes[]) or if an improper amount of arguments is given or if
     * file is not found
     */
    public static void main(String[] args) throws IOException {
        // We need 1 to 3 arguments to run
        if (args.length < 1 || args.length > 3)
            throw new IOException("Invalid amount of arguments");

        // The first argument is always the input file
        String input = args[0];
        boolean decompressing;
        String output;

        // With only one argument, we aren't decompressing and the output file is the input file
        if (args.length == 1) {
            decompressing = false;
            output = input;
        } else if (args.length == 2) // If we only have two arguments, it is either <input> <output> or <input> -d
            // If we supplied -d, then we are decompressing and the output file is the input file
            if (args[1].equals("-d")) {
                decompressing = true;
                output = input;
            } else {
                decompressing = false;
                output = args[1];
            }
        else { // If we have three arguments, we are decompressing and the output is specified
            decompressing = true;
            output = args[2];
        }

        // Get the string of the file
        String inputFileString = getFileString(input);

        if (decompressing) {
            // TODO Decompress the file
        } else {
            Compressor compressor = new Compressor(inputFileString);
            byte[] bytes = compressor.getBytes();
            FileOutputStream outputFile = new FileOutputStream(output);
            outputFile.write(bytes);
        }
    }
}
