package com.jcs.sort;

import java.util.Comparator;

/**
 * Naive sort with worst and average-case complexity of o(n^2) and best case of
 * o(n) for already sorted arrays
 *
 * @author rob
 */
public class Insertion {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 10, null, 12, null, 4, 16, 20, 33, 5};
        Insertion.sort(ints);
        System.out.println(SortUtil.toString(ints));
    }

    public static <T extends Comparable> void sort(T[] items) {
        sort(items, new DefaultComparator<T>());
    }

    public static <T> void sort(T[] items, Comparator<T> comparator) {
        if (items == null || items.length <= 1) {
            return;
        }
        int i;
        int j;
        //process the entire array
        for (i = 1; i < items.length; i++) {
            T key = items[i];
            //work backwards from i-1 to 0
            //  pair-wise swaps will occur until the key lands in the correct position
            //  at which point we can move on to the next key
            for (j = i - 1; j >= 0 && comparator.compare(key, items[j]) < 0; j--) {
                items[j + 1] = items[j];
            }
            items[j + 1] = key;
        }
    }

}
