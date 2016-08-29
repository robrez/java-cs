package com.jcs.leetcode;

/**
 * Loop through S once, check the longest length palindromic center at each
 * position i.
 *
 * T(n) = o(n) * o(n) = o(n^2) S(n) = o(1)
 *
 * there exists an o(n) algorithm, Manacher's Algorithm
 *
 * @author rar1941
 */
public class Prob0005LongestPalindromicSubstring {

    public static void main(String[] args) {
        Prob0005LongestPalindromicSubstring p = new Prob0005LongestPalindromicSubstring();
        String res = p.longestPalindrome("zxabbayz");
        System.out.println("res: " + res);
    }

    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        int n = s.length();
        int result;
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expandAround(s, i, i);
            int len2 = expandAround(s, i, i + 1);
            result = Math.max(len1, len2);
            if (result > end - start) {
                start = i - (result - 1) / 2;
                end = i + result / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAround(String s, int left, int right) {
        int len = s.length();
        while (left > 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
