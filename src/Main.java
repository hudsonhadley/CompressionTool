import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        String fileString;

        // Get a file name from the user and ensure that it is a valid file name
        while (true) {
            System.out.print("Please enter a file name> ");
            String fileName = inScanner.nextLine(); // Files could have spaces in them...

            // Try to get the Sting
            try {
                fileString = getFileString(fileName);
                break;
            } catch (FileNotFoundException fnfe) { // If we cannot find the file, we will try again...
                System.out.printf("The file named '%s' was not found\n", fileName);
            }
        }

        // Now that we have the file, we will determine the frequency of each character occurring within the text
        FrequencyTable frequencyTable = new FrequencyTable(fileString);

        System.out.println(frequencyTable);
    }
}
