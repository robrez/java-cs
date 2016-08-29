package com.jcs.sort;

import java.util.Comparator;

/**
 * T(n) = (n - 1) + (n - 2) + (n -3) ... + 1
 *
 * = n(n - 1) / 2
 *
 * = n^2
 *
 * @author rob
 */
public class Selection {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 10, null, 12, null, 4, 16, 20, 33, 5};
        Selection.sort(ints);
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
        int min;
        int n = items.length;
        // i can go to (n - 1) since j goes from (i + 1) to (n)
        for (i = 0; i < n - 1; i++) {
            min = i;
            for (j = i + 1; j < n; j++) {
                if (comparator.compare(items[j], items[min]) < 0) {
                    min = j;
                }
            }
            if (i != min) {
                SortUtil.swap(items, i, min);
            }
        }
    }

}
