package com.jcs.leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container. (this means the container is square)
 *
 * @author rar1941
 */
public class Prob0011ContainerWithMostWater {

    public static void main(String[] args) {
        Prob0011ContainerWithMostWater p = new Prob0011ContainerWithMostWater();
        Integer result = p.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
        System.out.println("result: " + result.toString());
    }

    public int maxArea(int[] height) {

        int n = height.length;

        int max = 0;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int a = computeAreaSquare(l, height[l], r, height[r]);
            if (a > max) {
                max = a;
            }
            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    private static int computeAreaSquare(int x1, int y1, int x2, int y2) {
        int rect = (Math.min(y1, y2) * (x2 - x1));
        return rect;
    }

    private static int computeAreaSlanted(int x1, int y1, int x2, int y2) {
        int rect = Math.max(y1, y2) * (x2 - x1);
        int tri = (Math.max(y1, y2) - Math.min(y1, y2) * (x2 - x1)) / 2;
        return rect - tri;
    }
}
