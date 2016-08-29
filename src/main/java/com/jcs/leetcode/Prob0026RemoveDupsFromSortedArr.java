package com.jcs.leetcode;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 *
 * For example, Given input array nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new
 * length.
 *
 * @author rar1941
 */
public class Prob0026RemoveDupsFromSortedArr {

    public static void main(String[] args) {
        Prob0026RemoveDupsFromSortedArr p = new Prob0026RemoveDupsFromSortedArr();
        Integer result = p.removeDuplicates(new int[]{1, 1, 2, 2, 2, 2, 3, 4, 4, 5});
        System.out.println("res: " + result.toString());

    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
