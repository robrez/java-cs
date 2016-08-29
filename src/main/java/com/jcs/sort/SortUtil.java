package com.jcs.sort;

import java.util.List;

/**
 * Utilities for sorting
 *
 * @author rob
 */
public class SortUtil {

    private static void indexCheck(int size, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index less than 0: " + Integer.toString(index));
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("Invalid index [" + Integer.toString(index) + "] is larger than " + Integer.toString(size - 1));
        }
    }

    public static void indexCheck(List items, int index) {
        indexCheck(items.size(), index);
    }

    public static void indexCheck(Object[] items, int index) {
        indexCheck(items.length, index);
    }

    public static <T> void swap(T[] items, int a, int b) {
        indexCheck(items, a);
        indexCheck(items, b);
        if (items != null && a != b) {
            T temp = items[a];
            items[a] = items[b];
            items[b] = temp;
        }
    }

    public static String toString(Object[] items) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            if (items[i] != null) {
                sb.append(items[i].toString());
            }
        }
        return sb.toString();
    }

}
