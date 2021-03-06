package com.jcs.leetcode;

/**
 * A sequence of numbers is called a wiggle sequence if the differences between
 * successive numbers strictly alternate between positive and negative. The
 * first difference (if one exists) may be either positive or negative. A
 * sequence with fewer than two elements is trivially a wiggle sequence.
 *
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences
 * (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5]
 * and [1,7,4,5,5] are not wiggle sequences, the first because its first two
 * differences are positive and the second because its last difference is zero.
 *
 * Given a sequence of integers, return the length of the longest subsequence
 * that is a wiggle sequence. A subsequence is obtained by deleting some number
 * of elements (eventually, also zero) from the original sequence, leaving the
 * remaining elements in their original order.
 *
 * Examples: Input: [1,7,4,9,2,5] Output: 6 The entire sequence is a wiggle
 * sequence.
 *
 * Input: [1,17,5,10,13,15,10,5,16,8] Output: 7 There are several subsequences
 * that achieve this length. One is [1,17,10,13,10,16,8].
 *
 * Input: [1,2,3,4,5,6,7,8,9] Output: 2
 *
 * @author rob
 */
public class Prob0376WiggleSubsequence {

    public static void main(String[] args) {
        Prob0376WiggleSubsequence p = new Prob0376WiggleSubsequence();
        int[] nums = new int[]{1, 7, 4, 9, 2, 5};  //6
        //int[] nums = new int[]{3, 3, 3, 2, 5}; //3
        //int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}; //2
        Integer result = p.wiggleMaxLengthDp(nums);
        System.out.println("res: " + result.toString());

    }

    /**
     * Greedy solution - simply count the number of alternating min and max
     * peaks. Time o(n) space o(1)
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int prevDif = nums[1] - nums[0];
        int max = prevDif == 0 ? 1 : 2;
        int diff;
        for (int i = 2; i < nums.length; i++) {
            diff = nums[i] - nums[i - 1];
            if ((prevDif <= 0 && diff > 0) || (prevDif >= 0 && diff < 0)) {
                max++;
                prevDif = diff;
            }
        }

        return max;
    }

    /**
     * Dynamic programming. Memoize the longest possible up and down wiggles
     * ending at position i. If nums[i] is less than nums[i - 1], up will equal
     * down + 1; likewise, if nums[i] is greater than nums[i - 1] down will be
     * equal to up + 1.
     *
     * Time o(n) space o(1)
     */
    public int wiggleMaxLengthDp(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int up = 1;
        int down = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }

}
