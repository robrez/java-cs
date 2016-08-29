package com.jcs.leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 *
 * Each element in the array represents your maximum jump length at that
 * position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example: Given array A = [2,3,1,1,4]
 *
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 *
 * @author rar1941
 */
public class Prob0045JumpGame2 {

    public static void main(String[] args) {
        Prob0045JumpGame2 p = new Prob0045JumpGame2();
        //int[] nums = new int[]{1, 1, 1, 0};
        int[] nums = new int[]{2, 3, 1, 1, 4};
        Integer result = p.jump(nums);
        System.out.println(result.toString());
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

    public int jump(int[] nums) {
        int maxReach = 0;
        int curEnd = 0;
        int jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > maxReach) {
                return -1;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = maxReach;
            }
        }
        return jumps;
    }
}
