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

    }

    /**
     * Adds a character and updates the frequency of it (if it hasn't been seen yet, an element is added to both array
     * lists)
     * @param c the character we want to add
     */
    public void add(char c) {

    }

    /**
     * Adds a string of characters and updates the frequency of each
     * @param s the string we want to add
     */
    public void add(String s) {

    }

    /**
     * Sees if a character has already been recorded by the table
     * @param c the character we want to check
     * @return true if the character has already been recorded by the table
     */
    private boolean contains(char c) {
        return false;
    }

    /**
     * Converts the frequency table into a string
     * @return A String representation of the frequency table
     */
    @Override
    public String toString() {
        return "";
    }
}
