package com.jcs.leetcode;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 *
 * 3,2,1 → 1,2,3
 *
 * 1,1,5 → 1,5,1
 *
 * @author rar1941
 */
public class Prob0031NextPermutation {

    public static void main(String[] args) {
        Prob0031NextPermutation p = new Prob0031NextPermutation();
        int[] nums = new int[]{1, 1, 5};
        p.nextPermutation(nums);
        System.out.println(toString(nums));
    }

    public static String toString(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(Integer.toString(nums[i]));
        }
        return sb.toString();
    }

    /**
     * A sequence has no next permutation if each subsequence is decreasing.
     *
     * eg: 5,4,3,2,1
     *
     * Search backwards til an item nums[i] is found such that nums[i] is less
     * than nums[i+1]. when such an item is found assign that let i be the index
     * of that item. Find an item j to the right of i such that j is just larger
     * than i. swap i and j. reverse the items to the right of i
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length;
            while (--j > i) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                }
            }
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int startPos) {
        int i = startPos;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
