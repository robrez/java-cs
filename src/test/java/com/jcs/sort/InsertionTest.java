package com.jcs.sort;

import com.jcs.sort.Insertion;

/**
 *
 * @author rob
 */
public class InsertionTest {

    /**
     * Integer tests suite
     */
    @org.junit.Test
    public void testSort_Integer() {
        System.out.println("Insertionsort Integer[]");
        for (SortTestCase<Integer> c : SortTestCase.integerSuite()) {
            Integer[] items = c.getInput();
            Insertion.sort(items);
            c.assertArrayEquals(items);
        }
    }

    /**
     * Integer tests suite
     */
    @org.junit.Test
    public void testSort_String() {
        System.out.println("Insertionsort String[]");
        for (SortTestCase<String> c : SortTestCase.stringSuite()) {
            String[] items = c.getInput();
            Insertion.sort(items);
            c.assertArrayEquals(items);
        }
    }

}
