package com.pmb.code.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lvrui
 */

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        Arrays.sort(coins);
        int[] dp = new int[coins.length];
        List<Integer> res = new ArrayList<>();
        findRes(coins.length - 1, dp, coins, amount, res);
        Collections.sort(res);
        return res.get(0);
    }

    private static void findRes(int i, int[] dp, int[] coins, int amount, List<Integer> res) {
        if (i < 0) {
            res.add(-1);
            return;
        }
        int num = amount / coins[i];
        dp[i] = num;
        int remainder = amount % coins[i];
        if (remainder == 0) {
            res.add(calc(dp));
        } else {
            if (coins[i] > amount) {
                findRes(i - 1, dp, coins, amount, res);
            } else {
                for (int j = 0; j <= num; j++) {
                    dp[i] = dp[i] - j;
                    remainder = remainder + coins[i] * j;
                    findRes(i - 1, dp, coins, remainder, res);
                }
            }
        }
    }

    public static int c(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        if (n == 0 || amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int j = 0; j < n; j++) {
            for (int i = coins[j]; i <= amount; i++) {
                int as = i;
                int a = dp[i];
                int b = dp[i - coins[j]] + 1;
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    private static int calc(int[] dp) {
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = res + dp[i];
        }
        return res;
    }

    /**
     * [186,419,83,408] 6249
     *
     * @param args
     */
    public static void main(String[] args) {
        int b = CoinChange.c(new int[] { 186, 419, 83, 408 }, 6249);
        b++;
    }

}
