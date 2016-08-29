package com.jcs.leetcode;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 *
 * This can be solved using the coin change algorithm from problem #322. There
 * is probably a non-DP linear solution similar to the "shortest jumps" problem
 *
 * there is a very fast mathematical solution using Lagrange's four-square
 * theorem
 *
 * @author rob
 */
public class Prob0279PerfectSquares {

    public static void main(String[] args) {
        Prob0279PerfectSquares p = new Prob0279PerfectSquares();
        Integer res = p.numSquaresGreedy(13);
        System.out.println("res:" + res.toString());
    }

    public int numSquaresGreedy(int n) {
        if (n == 1) {
            return 1;
        }
        int sizeN = -1;
        for (int i = 0; i < n; i++) {
            if (i * i <= n) {
                sizeN++;
            } else {
                break;
            }
        }
        return getNum(sizeN, n);
    }

    public int getNum(int j, int n) {
        if (j < 1) {
            return Integer.MAX_VALUE;
        }
        int square = j * j;
        if (square <= n) {
            int remainder = n % square;
            int count = n / square;
            if (remainder == 0) {
                return count;
            }
            int left = getNum(j - 1, remainder);
            if (left != Integer.MAX_VALUE) {
                left = left + count;
            }
            int right = getNum(j - 1, n);
            int min = Math.min(left, right);
            return min;
        }
        return getNum(j - 1, n);
    }

    public int numSquares(int n) {
        int sizeN = 0;
        int[] M = new int[n + 1];
        int[] P = new int[n + 1];
        int defVal = Integer.MAX_VALUE - 1;
        for (int i = 0; i < M.length; i++) {
            if (i * i <= n) {
                sizeN++;
            }
            M[i] = defVal;
            P[i] = -1;
        }
        int[] C = new int[sizeN];
        M[0] = 0;
        P[0] = 0;
        int i;
        int j;
        int prevMin;
        int curMin;
        for (i = 0; i < C.length; i++) {
            C[i] = i * i;
            for (j = C[i]; j < M.length; j++) {
                curMin = M[j];
                prevMin = M[j - C[i]];
                if (curMin > 1 && prevMin != defVal) {
                    prevMin = 1 + prevMin;
                    if (prevMin < curMin) {
                        M[j] = prevMin;
                        P[j] = i;
                    }
                }
            }
        }

        return M[n] == defVal ? -1 : M[n];
    }
}
