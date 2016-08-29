package com.jcs.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The thief has found himself a new place for his thievery again. There is only
 * one entrance to this area, called the "root." Besides the root, each house
 * has one and only one parent house. After a tour, the smart thief realized
 * that "all houses in this place forms a binary tree". It will automatically
 * contact the police if two directly-linked houses were broken into on the same
 * night.
 *
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 *
 * Example 1:
 *
 * 3
 *
 * 2 3
 *
 * 3 1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7. Example 2:
 *
 * 3
 *
 * 4 5
 *
 * 1 3 1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 * DP solution discussed nicely here:
 * https://discuss.leetcode.com/topic/39834/step-by-step-tackling-of-the-problem/2
 *
 * @author rob
 */
public class Prob0337HouseRobber3 {

    public static void main(String[] args) {
        Prob0337HouseRobber3 s = new Prob0337HouseRobber3();
        //TreeNode root = new TreeNode(3);
        //root.left = new TreeNode(2);
        //root.left.right = new TreeNode(3);
        //root.right = new TreeNode(3);
        //root.right.right = new TreeNode(1);

        TreeNode root = new TreeNode(4); //should be 7
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        Integer result = s.rob(root);
        System.out.println("res: " + result.toString());
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robSub(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        //res[0] will be the case where we do not take from root
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //res[1] will be the case where we do take from root
        res[1] = root.val + left[0] + right[0];

        return res;
    }

}
