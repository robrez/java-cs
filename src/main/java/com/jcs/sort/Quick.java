package com.jcs.sort;

import java.util.Comparator;

/**
 * Divide-and-conquer. Typical performance is o(n log n) Worst case is rare but
 * is o(n^2). Space complexity is O(1)
 *
 * Choose a pivot. Swap items until everything on the left of pivot is less than
 * pivot and everything on the right of pivot is greater than pivot. Repeat for
 * subproblems (k through p) and (p+1 through n)
 *
 * Strategies for choosing a pivot
 *
 * - use left or right or middle
 *
 * - use a "median-of-three"
 *
 * - use a random pivot
 *
 * Some performance tuning is to use insertion sort for sufficiently small
 * inputs or sub-problems (typically between size 8 and 20)
 *
 * In java 7, Vladimir Yaroslavskiy's dual pivot Quicksort replaced the
 * traditional (with optimizations) quicksort
 *
 * @author rob
 */
public class Quick {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 5, 1, 1, 6, 4};
        Quick.sort(ints);
        System.out.println(SortUtil.toString(ints));
    }

    public static <T extends Comparable> void sort(T[] items) {
        sort(items, new DefaultComparator<T>());
    }

    public static <T> void sort(T[] items, Comparator<T> comparator) {
        if (items == null || items.length <= 1) {
            return;
        }
        sort(items, comparator, 0, items.length - 1);
    }

    private static <T> void sort(T[] items, Comparator<T> comp, int left, int right) {
        if (left < right) {
            int p = part(items, comp, left, right);
            sort(items, comp, left, p);
            sort(items, comp, p + 1, right);
        }
    }

    private static <T> int part(T[] items, Comparator<T> comp, int left, int right) {
        T p = items[left + (right - left) / 2];
        int i = left - 1;
        int j = right + 1;
        while (true) {
            while (comp.compare(items[++i], p) < 0) {
            }
            while (comp.compare(items[--j], p) > 0) {
            }
            if (i >= j) {
                return j;
            }
            SortUtil.swap(items, i, j);
        }
    }

}
