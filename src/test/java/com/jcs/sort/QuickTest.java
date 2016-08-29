package com.jcs.sort;

import com.jcs.sort.Quick;

/**
 *
 * Tests for quicksort
 *
 * @author rob
 */
public class QuickTest {

    /**
     * Integer tests suite
     */
    @org.junit.Test
    public void testSort_Integer() {
        System.out.println("Quicksort Integer[]");
        for (SortTestCase<Integer> c : SortTestCase.integerSuite()) {
            Integer[] items = c.getInput();
            Quick.sort(items);
            c.assertArrayEquals(items);
        }
    }

    /**
     * Integer tests suite
     */
    @org.junit.Test
    public void testSort_String() {
        System.out.println("Quicksort String[]");
        for (SortTestCase<String> c : SortTestCase.stringSuite()) {
            String[] items = c.getInput();
            Quick.sort(items);
            c.assertArrayEquals(items);
        }
    }

}
