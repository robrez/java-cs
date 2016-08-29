package com.jcs.sort;

import java.util.Comparator;

/**
 * Naive algorithm with worst and average-case complexity of o(n^2) and
 * best-case of o(n)
 *
 * T(n) = (n -1) * (n - 1) * c
 *
 * = cn^2 - 2cn + 1
 *
 * = o(n^2)
 *
 * @author rob
 */
public class Bubble {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 10, null, 12, null, 4, 16, 20, 33, 5};
        Bubble.sort(ints);
        System.out.println(SortUtil.toString(ints));
    }

    public static <T extends Comparable> void sort(T[] items) {
        sort(items, new DefaultComparator<T>());
    }

    private static <T> void sortWiki(T[] items, Comparator<T> comparator) {
        if (items == null || items.length <= 1) {
            return;
        }
        int i;
        int n = items.length;
        //process the entire array
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (i = 1; i < n; i++) {
                if (comparator.compare(items[i - 1], items[i]) > 0) {
                    SortUtil.swap(items, i - 1, i);
                    swapped = true;
                }
            }
            //the nth largest element will be in position n after
            //  each pass, so the tail of the array can always be
            n--;
        }
    }

    public static <T> void sort(T[] items, Comparator<T> comparator) {
        if (items == null || items.length <= 1) {
            return;
        }
        int i;
        int j;
        int n = items.length;
        // keep scanning array and swapping pairs until no more swaps are needed
        boolean swapped;
        for (i = 1; i < n; i++) {
            // skip subproblems that were already encountered
            swapped = false;
            for (j = 0; j <= n - i - 1; j++) {
                if (comparator.compare(items[j], items[j + 1]) > 0) {
                    SortUtil.swap(items, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                //if a pass didn't perform any swaps, the array is sorted
                break;
            }
        }
    }

}
