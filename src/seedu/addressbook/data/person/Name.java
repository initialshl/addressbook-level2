package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public static final float NAME_SIMILAR_WORDS_THRESHOLD = 0.5f;

    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        name = name.trim();
        if (!isValidName(name)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = name;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }
    
    /**
     * Returns true of the other name is very similar to this name. 
     * Two names are considered similar if they have at least 
     * 50 percent match in case-insensitive words, in any order.
     */
    public boolean isSimilar(Name other) {
        if (other == null)
            return false;
        
        List<String> myWords = new ArrayList<String>(getWordsInName());
        List<String> otherWords = new ArrayList<String>(other.getWordsInName());
        
        // make both lists of words into lowercase
        ListIterator<String> iterator = myWords.listIterator();
        while (iterator.hasNext())
        {
            iterator.set(iterator.next().toLowerCase());
        }
        iterator = otherWords.listIterator();
        while (iterator.hasNext())
        {
            iterator.set(iterator.next().toLowerCase());
        }
        
        // check the words difference
        int similarThreshold = 0;
        if (myWords.size() >= otherWords.size()) {
            similarThreshold = (int)(myWords.size() * NAME_SIMILAR_WORDS_THRESHOLD);
            myWords.removeAll(otherWords);
            if (myWords.size() <= similarThreshold) {
                return true;
            }
        } else {
            similarThreshold = (int)(otherWords.size() * NAME_SIMILAR_WORDS_THRESHOLD);
            otherWords.removeAll(myWords);
            if (otherWords.size() <= similarThreshold) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

}
