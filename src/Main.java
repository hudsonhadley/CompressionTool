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
     * @throws IOException from FileOutputStream.write(bytes[]) or if an improper amount of arguments is given
     */
    public static void main(String[] args) throws IOException {

    }
}
