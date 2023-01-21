package com.pmb.code.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
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

    public static int coinChange2(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];  //dp[i]表示达到i用的最少硬币数  默认=初始化全为0
        for (int i = 1; i <= amount; i++) {  //目标为0 的不用计算
            dp[i] = 999999;   //此处不能用int的最大值，最大值+1 会溢出变为最小值
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == 999999 ? -1 : dp[amount];
    }

    /**
     * [186,419,83,408] 6249
     *
     * @param args
     */
    public static void main(String[] args) {
        int b = CoinChange.coinChange2(new int[]{186, 419, 83, 408}, 6249);
        b++;
    }

}
