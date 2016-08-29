package com.jcs.sort;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author rob
 */
public class QuickIterative {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 10, null, 12, null, 4, 16, 20, 33, 5};
        QuickIterative.sort(ints);
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
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(left);
        stack.push(right);
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            if (left < right) {
                int p = part(items, comp, left, right);
                stack.push(left);
                stack.push(p);
                stack.push(p + 1);
                stack.push(right);
            }
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
