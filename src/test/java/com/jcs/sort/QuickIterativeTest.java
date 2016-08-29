package com.jcs.sort;

import com.jcs.sort.QuickIterative;

/**
 *
 * @author rob
 */
public class QuickIterativeTest {

    /**
     * Integer tests suite
     */
    @org.junit.Test
    public void testSort_Integer() {
        System.out.println("Quicksort Iterative Integer[]");
        for (SortTestCase<Integer> c : SortTestCase.integerSuite()) {
            Integer[] items = c.getInput();
            QuickIterative.sort(items);
            c.assertArrayEquals(items);
        }
    }

    /**
     * Integer tests suite
     */
    @org.junit.Test
    public void testSort_String() {
        System.out.println("Quicksort Iterative String[]");
        for (SortTestCase<String> c : SortTestCase.stringSuite()) {
            String[] items = c.getInput();
            QuickIterative.sort(items);
            c.assertArrayEquals(items);
        }
    }

}
