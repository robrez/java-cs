package com.jcs.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 *
 * @author rar1941
 */
public class Prob0014LongestCommonPrefix {

    public static void main(String[] args) {
        Prob0014LongestCommonPrefix p = new Prob0014LongestCommonPrefix();
        String[] vals = new String[]{
            "leets", "leetcode", "leet", "leeds"
        };

        String res = p.longestCommonPrefix(vals);
        System.out.println("res:" + res);

    }

    public String longestCommonPrefix(String[] strs) {

        return binarySearch(strs);
        //return divideAndConquer(strs);
    }

    public String divideAndConquer(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        return divideAndConquer(strs, 0, strs.length - 1);
    }

    public String divideAndConquer(String[] strs, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            String ls = divideAndConquer(strs, l, mid);
            String rs = divideAndConquer(strs, mid + 1, r);
            return lcs(ls, rs);
        }
        return strs[l];
    }

    private String lcs(String s1, String s2) {
        int n = Math.min(s1.length(), s2.length());
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i);
            }
        }
        return s1.substring(0, n);
    }

    private String binarySearch(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int n = strs.length;
        int maxP = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            maxP = Math.min(maxP, strs[i].length());
        }

        int low = 1;
        int high = maxP;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}
