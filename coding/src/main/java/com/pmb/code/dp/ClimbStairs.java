package com.pmb.code.dp;

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author lvrui
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int res = 0;
        if (n <= 0) {
            return res;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int index = 2; index < n; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        res = dp[n - 1];
        return res;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int i = climbStairs.climbStairs(1);
    }
}
