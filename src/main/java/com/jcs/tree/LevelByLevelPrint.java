package com.jcs.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author rob
 */
public class LevelByLevelPrint {

    public static void main(String[] args) {
        //TreeNode root = new TreeNode(3);
        //root.left = new TreeNode(2);
        //root.left.right = new TreeNode(3);
        //root.right = new TreeNode(3);
        //root.right.right = new TreeNode(1);

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        LevelByLevelPrint.go(root);
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void go(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode cur = root;
        int row = 0;
        int levelCount = 1;
        int currentCount = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(cur);

        while (!q.isEmpty()) {
            cur = q.poll();
            if (cur.left != null) {
                q.offer(cur.left);
                currentCount++;
            }
            if (cur.right != null) {
                q.offer(cur.right);
                currentCount++;
            }
            System.out.print(Integer.toString(cur.val) + " ");
            levelCount--;
            if (levelCount == 0) {
                System.out.println("");
                levelCount = currentCount;
                row++;
            }
        }
        System.out.println("");

    }

}
