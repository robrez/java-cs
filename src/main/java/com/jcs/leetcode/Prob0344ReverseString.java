package com.jcs.leetcode;

/**
 *
 * @author rob
 */
public class Prob0344ReverseString {

    public static void main(String[] args) {
        Prob0344ReverseString p = new Prob0344ReverseString();
        String res = p.reverseString("hello");
        System.out.println("res: " + res);
    }

    public String reverseString(String s) {
        char[] reversed = s.toCharArray();
        int i = 0;
        int j = reversed.length - 1;
        char c;
        while (i < j) {
            c = reversed[i];
            reversed[i] = reversed[j];
            reversed[j] = c;
            i++;
            j--;
        }
        return new String(reversed);
    }

}
