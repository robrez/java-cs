package com.jcs.leetcode;

import java.util.BitSet;

/**
 * There are n bulbs that are initially off. You first turn on all the bulbs.
 * Then, you turn off every second bulb. On the third round, you toggle every
 * third bulb (turning on if it's off or turning off if it's on). For the ith
 * round, you toggle every i bulb. For the nth round, you only toggle the last
 * bulb. Find how many bulbs are on after n rounds.
 *
 * Example:
 *
 * Given n = 3. * At first, the three bulbs are [off, off, off].
 *
 * After first round, the three bulbs are [on, on, on].
 *
 * After second round, the three bulbs are [on, off, on].
 *
 * After third round, the three bulbs are [on, off, off].
 *
 * So you should return 1, because there is only one bulb is on.
 *
 * @author rob
 */
public class Prob0319BulbSwitcher {

    public static void main(String[] args) {
        Prob0319BulbSwitcher p = new Prob0319BulbSwitcher();
        Integer res = p.bulbSwitch(3);
        System.out.println("res: " + res.toString());
    }

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(((double) n));
    }

    public int bulbSwitchNaive(int n) {
        BitSet b = new BitSet(n);
        b.set(0, n, false);
        int round;
        int i;
        for (round = 1; round <= n; round++) {
            for (i = (round - 1); i < n; i += round) {
                b.set(i, !b.get(i));
            }
        }
        return b.cardinality();
    }

}
