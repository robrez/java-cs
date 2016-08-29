package com.jcs.sort;

import java.util.Comparator;

/**
 * Default comparator
 *
 * @author rob
 * @param <T>
 */
public final class DefaultComparator<T extends Comparable> implements Comparator<T> {

    @Override
    public int compare(T a, T b) {
        if (a == null && b == null) {
            return 0;
        } else if (a == null) {
            return 1;
        } else if (b == null) {
            return -1;
        }
        return a.compareTo(b);
    }

}
