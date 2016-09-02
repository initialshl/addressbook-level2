package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void testIsAnyNull() {
        
        // initialize different data types
        Object n = null;
        Object o = new Object();
        String s = "";
        int i = 0;
        int[] a = { 0, 0, 0, 0, 0 };
        
        // no input
        assertFalse(Utils.isAnyNull());

        // empty String input
        assertFalse(Utils.isAnyNull(s));

        // Object input
        assertFalse(Utils.isAnyNull(new Object()));

        // primitive data type input
        assertFalse(Utils.isAnyNull(i));

        // array of primitive data type input
        assertFalse(Utils.isAnyNull(a));
        
        // multiple non-null types input
        assertFalse(Utils.isAnyNull(s, i, a));

        // one null object input
        assertTrue(Utils.isAnyNull(n));

        // all null object input
        assertTrue(Utils.isAnyNull(n, n, n, n, n));

        // some null object input
        assertTrue(Utils.isAnyNull(a, n, s, n, o, i));
        
        // many non-null and one null input
        assertTrue(Utils.isAnyNull(o, o, o, o, o, o, 
                o, o, o, o, o, o, o, o, o, o, o, o, 
                o, o, o, o, o, o, o, o, o, o, o, o, 
                o, o, o, o, o, o, o, o, o, o, o, o, 
                o, o, o, o, o, o, o, o, o, o, o, o, 
                a, a, a, a, a, a, a, a, a, a, a, n));
    }
    
    @Test
    public void testElementsAreUnique() {
        
        // initialize empty collections
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();

        // empty list input
        assertTrue(Utils.elementsAreUnique(list));

        // empty set input
        assertTrue(Utils.elementsAreUnique(set));
        
        // add null to collections
        list.clear();
        list.add(null);
        set.clear();
        set.add(null);

        // one null element list input
        assertTrue(Utils.elementsAreUnique(list));

        // one null element set input
        assertTrue(Utils.elementsAreUnique(set));
        
        // add one element to collections
        list.clear();
        list.add(9);
        set.clear();
        set.add(9);

        // one non-null element list input
        assertTrue(Utils.elementsAreUnique(list));

        // one non-null element set input
        assertTrue(Utils.elementsAreUnique(set));
        
        // add one null and one element to collections
        list.clear();
        list.add(null);
        list.add(9);
        set.clear();
        set.add(null);
        set.add(9);

        // one null and one element list input
        assertTrue(Utils.elementsAreUnique(list));

        // one null and one element set input
        assertTrue(Utils.elementsAreUnique(set));
        
        // add two different elements to collections
        list.clear();
        list.add(1);
        list.add(9);
        set.clear();
        set.add(1);
        set.add(9);

        // two null list input
        assertTrue(Utils.elementsAreUnique(list));

        // two null set input
        assertTrue(Utils.elementsAreUnique(set));
        
        // add two null to collections
        list.clear();
        list.add(null);
        list.add(null);
        set.clear();
        set.add(null);
        set.add(null);

        // two null list input
        assertFalse(Utils.elementsAreUnique(list));

        // two null set input
        assertTrue(Utils.elementsAreUnique(set));       // set behavior: returns true
        
        // add two same elements to collections
        Integer i = new Integer(1);
        list.clear();
        list.add(i);
        list.add(i);
        set.clear();
        set.add(i);
        set.add(i);

        // two same elements list input
        assertFalse(Utils.elementsAreUnique(list));

        // two same elements set input
        assertTrue(Utils.elementsAreUnique(set));       // set behavior: returns true
        
        // add many same elements to collections
        list.clear();
        list.add(i);
        list.add(i);
        list.add(i);
        list.add(i);
        list.add(i);
        set.clear();
        set.add(i);
        set.add(i);
        set.add(i);
        set.add(i);
        set.add(i);

        // many same elements list input
        assertFalse(Utils.elementsAreUnique(list));

        // many same elements set input
        assertTrue(Utils.elementsAreUnique(set));       // set behavior: returns true
        
        // add many different elements to collections
        list.clear();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        set.clear();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        // many different elements list input
        assertTrue(Utils.elementsAreUnique(list));

        // many different elements set input
        assertTrue(Utils.elementsAreUnique(set));
        
        // add many mixed elements to collections
        list.clear();
        list.add(1);
        list.add(i);
        list.add(3);
        list.add(4);
        list.add(i);
        set.clear();
        set.add(1);
        set.add(i);
        set.add(3);
        set.add(4);
        set.add(i);

        // many mixed elements list input
        assertFalse(Utils.elementsAreUnique(list));

        // many mixed elements set input
        assertTrue(Utils.elementsAreUnique(set));       // set behavior: returns true
    }
}
