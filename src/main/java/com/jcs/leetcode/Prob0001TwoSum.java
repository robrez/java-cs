package com.jcs.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given array of ints return zero-based indices of two ints that add up to
 * target int. Assume that there is exactly one solution
 *
 * @author rar1941
 */
public class Prob0001TwoSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] nums = new int[] { 2, 7, 11, 15 };
        int target= 9;
        Prob0001TwoSum p = new Prob0001TwoSum();
        int[] result = p.twoSum(nums, target);
        if(result.length == 2) {
            System.out.println("(" + Integer.toString(result[0]) + ", " + Integer.toString(result[1]) + ")");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
        valueMap.put(nums[0], 0);
        for(int i = 1; i < nums.length; i++) {
            int compliment = target - nums[i];
            if(valueMap.containsKey(compliment)) {
                return new int[] { valueMap.get(compliment), i };
            }
            valueMap.put(nums[i], i);
        }
        return new int[0];
    }
}
