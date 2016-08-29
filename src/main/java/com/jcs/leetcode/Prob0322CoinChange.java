package com.jcs.leetcode;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 *
 * Example 1: coins = [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1)
 *
 * Example 2: coins = [2], amount = 3 return -1.
 *
 * Note: You may assume that you have an infinite number of each kind of coin.
 *
 * @author rob
 */
public class Prob0322CoinChange {

    public static void main(String[] args) {
        Prob0322CoinChange p = new Prob0322CoinChange();
        int[] coins = new int[]{5, 2, 1};
        int amt = 11;
        Integer result = p.coinChange(coins, amt);
        System.out.println("result: " + result);
    }

    /**
     * O(total * numCoins). Since total is not proportional to numCoins in
     * anyway, the runtime is pseudo-polynomial. Space complexity is o(total);
     */
    public int coinChange(int[] coins, int amount) {
        int[] M = new int[amount + 1];
        //int[] P = new int[amount + 1];
        int defaultVal = Integer.MAX_VALUE - 1;
        for (int i = 0; i < M.length; i++) {
            M[i] = defaultVal;
            //P[i] = -1;
        }
        M[0] = 0;
        //P[0] = 0;
        int prevMin;
        int curMin;
        int i = 0;
        int j;
        for (i = 0; i < coins.length; i++) {
            for (j = coins[i]; j < M.length; j++) {
                curMin = M[j];
                prevMin = M[j - coins[i]];
                if (curMin > 1 && prevMin != defaultVal) {
                    prevMin = 1 + prevMin;
                    if (prevMin < curMin) {
                        M[j] = prevMin;
                        //P[j] = i;
                    }
                }
            }
        }
        return M[M.length - 1] == defaultVal ? -1 : M[M.length - 1];
    }
}
