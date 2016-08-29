package com.jcs.sort;

import java.util.Comparator;

/**
 * Divide and conquer. Worst and average case performance is O(n log n). space
 * complexity is O(n)
 *
 * T(n) = C(divide) + 2T(n/2) + (c*n)(merge)
 *
 * = (1 + log n) * cn
 *
 * = theta(n log n)
 *
 * @author rob
 */
public class Merge {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 10, null, 12, null, 4, 16, 20, 33, 5};
        Merge.sort(ints);
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
            int mid = left + (right - left) / 2;
            sort(items, comp, left, mid);
            sort(items, comp, mid + 1, right);
            merge2(items, comp, left, mid, right);
        }
    }

    private static <T> void merge(T[] items, Comparator<T> comp, int left, int mid, int right) {
        T[] c = (T[]) new Object[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            //until either left or right has been exhausted,
            //  choose the smaller value from either side
            if (comp.compare(items[i], items[j]) <= 0) {
                c[k++] = items[i++];
            } else {
                c[k++] = items[j++];
            }
        }
        // Copy remaining items from the non-empty half
        while (i <= mid) {
            c[k++] = items[i++];
        }
        while (j <= right) {
            c[k++] = items[j++];
        }
        i = left;
        System.arraycopy(c, 0, items, i, c.length);
        //for (int k = 0; k < c.length; k++) {
        //items[i++] = c[k];
        //}
    }

    private static <T> void merge2(T[] items, Comparator<T> comp, int left, int mid, int right) {
        int nL = mid - left + 1;
        int nR = right - mid;
        T[] aL = (T[]) new Object[nL];
        T[] aR = (T[]) new Object[nR];
        int i;
        int j;
        int k;
        for (i = 0; i < nL; i++) {
            aL[i] = items[left + i];
        }
        for (j = 0; j < nR; j++) {
            aR[j] = items[mid + 1 + j];
        }
        i = 0;
        j = 0;
        k = left;
        while (i < nL && j < nR) {
            //until either left or right has been exhausted,
            //  choose the smaller value from either side
            if (comp.compare(aL[i], aR[j]) <= 0) {
                items[k++] = aL[i++];
            } else {
                items[k++] = aR[j++];
            }
        }
        // Copy remaining items from the non-empty half
        while (i < nL) {
            items[k++] = aL[i++];
        }
        while (j < nR) {
            items[k++] = aR[j++];
        }
    }

}
