package com.jcs.sort;

import com.jcs.sort.Merge;

/**
 *
 * @author rob
 */
public class MergeTest {

    /**
     * Integer tests suite
     */
    @org.junit.Test
    public void testSort_Integer() {
        System.out.println("Mergesort Integer[]");
        for (SortTestCase<Integer> c : SortTestCase.integerSuite()) {
            Integer[] items = c.getInput();
            Merge.sort(items);
            c.assertArrayEquals(items);
        }
    }

    /**
     * Integer tests suite
     */
    @org.junit.Test
    public void testSort_String() {
        System.out.println("Mergesort String[]");
        for (SortTestCase<String> c : SortTestCase.stringSuite()) {
            String[] items = c.getInput();
            Merge.sort(items);
            c.assertArrayEquals(items);
        }
    }

}
