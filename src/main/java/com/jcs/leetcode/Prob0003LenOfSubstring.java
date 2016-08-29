package com.jcs.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * @author rob
 */
public class Prob0003LenOfSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int i = 0;
        int j = 0;
        int len = s.length();
        int max = 0;
        char c;
        for (j = 0; j < len; j++) {
            c = s.charAt(j);
            if (charMap.containsKey(c)) {
                i = Math.max(i, charMap.get(c));
            }
            charMap.put(c, j + 1);
            max = Math.max(max, (j - i) + 1);
        }
        return max;
    }

}
