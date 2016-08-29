package com.jcs.sort;

import com.jcs.sort.Bubble;

/**
 *
 * @author rob
 */
public class BubbleTest {

    /**
     * Integer tests suite
     */
    @org.junit.Test
    public void testSort_Integer() {
        System.out.println("Bubblesort Integer[]");
        for (SortTestCase<Integer> c : SortTestCase.integerSuite()) {
            Integer[] items = c.getInput();
            Bubble.sort(items);
            c.assertArrayEquals(items);
        }
    }

    /**
     * Integer tests suite
     */
    @org.junit.Test
    public void testSort_String() {
        System.out.println("Bubblesort String[]");
        for (SortTestCase<String> c : SortTestCase.stringSuite()) {
            String[] items = c.getInput();
            Bubble.sort(items);
            c.assertArrayEquals(items);
        }
    }

}
