package com.jcs.leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 *
 * Each element in the array represents your maximum jump length at that
 * position.
 *
 * Determine if you are able to reach the last index.
 *
 * For example: A = [2,3,1,1,4], return true.
 *
 * A = [3,2,1,0,4], return false.
 *
 * @author rar1941
 */
public class Prob0055JumpGame {

    public static void main(String[] args) {
        Prob0055JumpGame p = new Prob0055JumpGame();
        //int[] nums = new int[]{1, 1, 1, 0};
        int[] nums = new int[]{3, 2, 1, 0, 4};
        Boolean result = p.canJump(nums);
        System.out.println(result.toString() + " " + toString(nums));
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

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                break;
            }
        }
        return (maxReach >= nums.length - 1);
    }
}
