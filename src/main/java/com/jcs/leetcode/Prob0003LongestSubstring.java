package com.jcs.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Solution is a sliding window
 *
 * @author rar1941
 */
public class Prob0003LongestSubstring {

    public static void main(String[] args) {
        Prob0003LongestSubstring p = new Prob0003LongestSubstring();

        Integer result = p.lengthOfLongestSubstring("bbbbb");

        System.out.println("result: " + result.toString());
    }

    /**
     * Sliding window. Increment maxLen until a character is repeated. Once a
     * character is repeated, move the window's lower boundary to the index of
     * that character's previous position + 1 and result will be recomputed
     * as Max(previousResult, current upper-bondary - new lower boundary)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int i = 0;
        int len = 0;
        int j;

        Map<Character, Integer> charPos = new HashMap<>();

        Character c;
        for (j = 0; j < n; j++) {
            c = s.charAt(j);
            if (charPos.containsKey(c)) {
                i = Math.max(i, charPos.get(c));
            }
            len = Math.max(len, (j - i) + 1);
            charPos.put(c, j + 1);
        }

        return len;
    }
}
