import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileComparison {
    public static void main(String[] args) throws IOException {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter a file to compress and decompress: ");
        String fileName = inputScanner.nextLine();
        File inFile = new File(fileName);

        Compressor compressor = new Compressor(Main.getFileString(fileName));
        Decompressor decompressor = new Decompressor(compressor.compress());

        Scanner file1Scanner = new Scanner(inFile);
        Scanner file2Scanner = new Scanner(decompressor.decompress());

        file1Scanner.useDelimiter("");
        file2Scanner.useDelimiter("");

        int totalChars = 0;
        int totalMessUps = 0;
        while (file1Scanner.hasNext() && file2Scanner.hasNext()) {
            char c1 = file1Scanner.next().charAt(0);
            char c2 = file2Scanner.next().charAt(0);
            totalChars++;

            if (c1 != c2) {
                totalMessUps++;
            }
        }

        int totalRestored = totalChars - totalMessUps;

        System.out.printf("%.2f%% of the file was restored", 100 * ((double) totalRestored) / totalChars);
    }
}
