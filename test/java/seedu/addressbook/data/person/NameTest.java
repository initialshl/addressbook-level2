package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    private Name name;
    
    @Before
    public void setup() throws IllegalValueException {
        name = new Name("John Doe");
    }
    
    @Test
    public void testIsSimilar() throws IllegalValueException {
        
        // null input
        assertFalse(name.isSimilar(null));

        // different name input
        assertFalse(name.isSimilar(new Name("Peter Parker")));

        // 40 percent match input
        assertFalse(name.isSimilar(new Name("cool John cool Doe cool")));

        // 25 percent match input
        assertFalse(name.isSimilar(new Name("cool John cool cool")));

        // 10 percent match long input
        assertFalse(name.isSimilar(new Name("cool cool cool cool cool John"
                + "cool cool cool cool cool cool cool cool cool cool cool"
                + " Doe cool cool")));
        
        // exact match input
        assertTrue(name.isSimilar(new Name("John Doe")));
        
        // upper case input
        assertTrue(name.isSimilar(new Name("JOHN DOE")));

        // lower case input
        assertTrue(name.isSimilar(new Name("john doe")));

        // many whitespace matching input
        assertTrue(name.isSimilar(new Name("      John        Doe     ")));

        // one word 50 percent match input
        assertTrue(name.isSimilar(new Name("John")));

        // 50 percent match input
        assertTrue(name.isSimilar(new Name("JOHN john")));

        // 66 percent match input
        assertTrue(name.isSimilar(new Name("John cool Doe")));
        
    }
    
}
