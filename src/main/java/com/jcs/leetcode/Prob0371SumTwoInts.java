package com.jcs.leetcode;

/**
 * Sum two integers without using + or minus operators
 *
 * sum = A XOR B
 *
 * carry = (A AND B) << 1
 *
 * borrow = ((NOT A) AND B) << 1
 *
 *
 * @author rob
 */
public class Prob0371SumTwoInts {

    public static void main(String[] args) {
        Prob0371SumTwoInts p = new Prob0371SumTwoInts();
        Integer sum = p.getSum(3, 6);
        //Integer sum = p.subtractRecursive(9, 2);
        //Integer sum = p.subtractIterative(9, -2);
        System.out.println("res: " + sum.toString());

    }

    public int getSum(int a, int b) {
        return addRecursive(a, b);
    }

    public int addRecursive(int a, int b) {
        if (b == 0) {
            //loop until there is no carry
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return addRecursive(sum, carry);
    }

    public int addIterative(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = (a ^ b);
            b = carry;
        }
        return a;
    }

    public int subtractRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        int dif = a ^ b;
        int borrow = (~a & b) << 1;
        return subtractRecursive(dif, borrow);
    }

    public int subtractIterative(int a, int b) {
        while (b != 0) {
            int borrow = (~a & b) << 1;
            a = a ^ b;
            b = borrow;
        }
        return a;
    }
}
