package com.jcs.leetcode;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
 * nums[2] < nums[3]....
 *
 * Example:
 *
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1,
 * 6].
 *
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1,
 * 2].
 *
 * Note: You may assume all input has valid answer.
 *
 * Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
 * @author rob
 */
public class Prob0324WiggleSort {

    public static void main(String[] args) {
        Prob0324WiggleSort p = new Prob0324WiggleSort();
        //int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        //int[] nums = new int[]{1, 1, 2, 1, 2, 2, 1};
        int[] nums = new int[]{1, 3, 2, 2, 3, 1};
        p.wiggleSort(nums);
        String res = toString(nums);
        System.out.println(res);
    }

    public static String toString(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(Integer.toString(nums[i]));
        }
        return sb.toString();
    }

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }
        doQuick(nums, 0, n - 1);
        int[] temp = Arrays.copyOf(nums, n);
        int mid = n % 2 == 0 ? n / 2 - 1 : n / 2;
        int index = -1;
        int i;
        for (i = 0; i <= mid; i++) {
            nums[++index] = temp[mid - i];
            if (++index < n) {
                nums[index] = temp[n - i - 1];
            }
        }
    }

    private void doQuick(int[] nums, int left, int right) {
        if (left < right) {
            int mid = quickPart(nums, left, right);
            doQuick(nums, left, mid);
            doQuick(nums, mid + 1, right);
        }
    }

    private int quickPart(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        int i = left - 1;
        int j = right + 1;
        int p = nums[mid];
        while (true) {
            while (nums[++i] < p) {
            }
            while (nums[--j] > p) {
            }
            if (i >= j) {
                return j;
            } else {
                swap(nums, i, j);
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

}
