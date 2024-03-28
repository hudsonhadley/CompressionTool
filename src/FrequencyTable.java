import java.util.ArrayList;
import java.util.Scanner;

/**
 * The FrequencyTable class represents a table of frequencies of characters for a specific string
 * @author Hudson Hadley
 */
public class FrequencyTable {
    /**
     * The list of characters (the index of these correspond to the frequencies array list
     */
    private ArrayList<Character> characters;
    /**
     * The list of frequencies (the index of these correspond to the characters array list
     */
    private ArrayList<Integer> frequencies;

    /**
     * A constructor which creates an empty table
     */
    public FrequencyTable() {
        this.characters = new ArrayList<>();
        this.frequencies = new ArrayList<>();
    }

    /**
     * A constructor which creates a table based on a string
     * @param input the string we want to make a frequency table off of
     */
    public FrequencyTable(String input) {
        this.characters = new ArrayList<>();
        this.frequencies = new ArrayList<>();
        add(input);
    }

    /**
     * A constructor which creates a table based on a list of chars and frequencies
     * @param characters the characters in the table
     * @param frequencies the times each character shows up
     */
    public FrequencyTable(ArrayList<Character> characters, ArrayList<Integer> frequencies) {
        this.characters = new ArrayList<>(characters);
        this.frequencies = new ArrayList<>(frequencies);
    }

    /**
     * Adds a character and updates the frequency of it (if it hasn't been seen yet, an element is added to both array
     * lists)
     * @param c the character we want to add
     */
    public void add(char c) {
        try { // Try to increment
            increment(c);
        } catch (IllegalArgumentException iae) { // If the character is not in the list, add it
            characters.add(c);
            frequencies.add(1);
        }
    }

    /**
     * Adds a string of characters and updates the frequency of each
     * @param s the string we want to add
     */
    public void add(String s) {
        Scanner stringScanner = new Scanner(s);
        stringScanner.useDelimiter("");

        // Go through every character (whitespace included)
        while (stringScanner.hasNext()) {
            char character = stringScanner.next().charAt(0);
            add(character);
        }

        stringScanner.close();
    }

    /**
     * Increments the index corresponding to a character by 1
     * @param c the character we want to increment
     * @throws IllegalArgumentException if the character is not in the array list
     */
    private void increment(char c) throws IllegalArgumentException {
        int index = getIndex(c);
        frequencies.set(index, frequencies.get(index) + 1); // Increment by one
    }

    /**
     * @param c the character we want the index of
     * @return the index of the character c
     * @throws IllegalArgumentException if the character is not found
     */
    private int getIndex(char c) {
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).equals(c))
                return i;
        }
        // If we reach the end and haven't found it, we have not recorded it
        throw new IllegalArgumentException("Character not found");
    }

    /**
     * @param c the character we want the frequency of
     * @return the frequency of character c
     * @throws IllegalArgumentException if c is not found
     */
    public int getFrequency(char c) throws IllegalArgumentException {
        return frequencies.get(getIndex(c));
    }

    /**
     * @param index the index of the character we want the frequency of
     * @return the frequency of characters.get(index)
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public int getFrequency(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= frequencies.size())
            throw new IndexOutOfBoundsException("Invalid index");

        return frequencies.get(index);
    }

    /**
     * @param index the index of the character we want
     * @return the character at characters.get(index)
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public char getChar(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= characters.size())
            throw new IndexOutOfBoundsException("Invalid index");

        return characters.get(index);
    }

    /**
     * @return the size of the frequency table (i.e. how many characters we have tracked)
     */
    public int getSize() {
        return characters.size();
    }

    /**
     * @return the greatest frequency in the table
     */
    public int getMaxFrequency() {
        int max = 0;

        for (int frequency : frequencies) {
            if (frequency > max)
                max = frequency;
        }

        return max;
    }

    /**
     * Converts the frequency table into a string
     * @return A String representation of the frequency table
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < characters.size(); i++) {
            stringBuilder.append(characters.get(i));
            stringBuilder.append(": ");
            stringBuilder.append(frequencies.get(i));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
