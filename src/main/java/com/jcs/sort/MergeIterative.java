package com.jcs.sort;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author rob
 */
public class MergeIterative {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 10, null, 12, null, 4, 16, 20, 33, 5};
        MergeIterative.sort(ints);
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
        Deque<Integer> stack = new LinkedList<>();
        stack.push(left);
        stack.push(right);
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            if (left < right) {
                int mid = left + (right - left) / 2;
                stack.push(left);
                stack.push(mid);
                stack.push(mid + 1);
                stack.push(right);
                merge(items, comp, left, mid, right);
            }
        }
    }

    private static <T> void merge(T[] items, Comparator<T> comp, int left, int mid, int right) {
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
