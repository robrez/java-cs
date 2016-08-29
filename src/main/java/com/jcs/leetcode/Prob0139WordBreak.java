package com.jcs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given s = "leetcode", dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * @author rob
 */
public class Prob0139WordBreak {

    public static void main(String[] args) {
        List<WordBreakTestCase> cases = WordBreakTestCase.getTestCases();
        Prob0139WordBreak b = new Prob0139WordBreak();
        for (WordBreakTestCase c : cases) {
            Boolean res = b.wordBreak(c.getStr(), c.getDict());
            System.out.println(res.toString());
        }
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        int sLen = s.length();
        //w[i] is true if s.substring(j, i) is a word and w[j] is true
        //     w[j] check ensures that ALL tokens are words
        boolean[] w = new boolean[sLen + 1];
        w[0] = true;
        int i;
        int j;
        for (i = 1; i <= sLen; i++) {
            for (j = 0; j < i; j++) {
                if (w[j] && wordDict.contains(s.substring(j, i))) {
                    w[i] = true;
                    break;
                }
            }
        }
        return w[sLen];
    }

    public static final class WordBreakTestCase {

        private final String str;
        private final Set<String> dict;

        private WordBreakTestCase(String str, String... words) {
            this.str = str;
            dict = new HashSet<String>();
            dict.addAll(Arrays.asList(words));
        }

        public static WordBreakTestCase create(String str, String... words) {
            return new WordBreakTestCase(str, words);
        }

        public String getStr() {
            return str;
        }

        public Set<String> getDict() {
            return dict;
        }

        public static List<WordBreakTestCase> getTestCases() {
            List<WordBreakTestCase> l = new ArrayList<WordBreakTestCase>();
            l.add(WordBreakTestCase.create("leetcode", "leet", "code"));
            l.add(WordBreakTestCase.create("dogs", "dog", "s", "gs"));
            l.add(WordBreakTestCase.create("acccbccb", "cc", "bc", "ac", "ca"));
            l.add(WordBreakTestCase.create("bb", "a", "b", "bbb", "bbbb"));
            return l;
        }
    }

}
