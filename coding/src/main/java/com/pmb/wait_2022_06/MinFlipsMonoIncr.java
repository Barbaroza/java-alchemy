package com.pmb.wait_2022_06;

/**
 * https://leetcode.cn/problems/flip-string-to-monotone-increasing/solution/jiang-zi-fu-chuan-fan-zhuan-dao-dan-diao-stjd/
 * 926. 将字符串翻转到单调递增
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 * <p>
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 * <p>
 * 返回使 s 单调递增的最小翻转次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "00110"
 * 输出：1
 * 解释：翻转最后一位得到 00111.
 * 示例 2：
 * <p>
 * 输入：s = "010110"
 * 输出：2
 * 解释：翻转得到 011111，或者是 000111。
 * 示例 3：
 * <p>
 * 输入：s = "00011000"
 * 输出：2
 * 解释：翻转得到 00000000。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 为 '0' 或 '1'
 *
 * @author lvrui
 */
public class MinFlipsMonoIncr {
    private static final char ZERO = '0';
    private static final char ONE = '1';

    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length + 1][2];

        for (int index = 1; index < chars.length + 1; index++) {

            if (ZERO == chars[index - 1]) {
                dp[index][0] = dp[index - 1][0];
                dp[index][1] = Math.min(dp[index - 1][0], dp[index - 1][1]) + 1;
            } else {
                dp[index][0] = dp[index - 1][0] + 1;
                dp[index][1] = Math.min(dp[index - 1][0], dp[index - 1][1]);
            }


        }
        return Math.min(dp[chars.length][0], dp[chars.length][1]);
    }
    public int minFlipsMonoIncr2(String s) {
        int n = s.length();
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int dp0New = dp0, dp1New = Math.min(dp0, dp1);
            if (c == '1') {
                dp0New++;
            } else {
                dp1New++;
            }
            dp0 = dp0New;
            dp1 = dp1New;
        }
        return Math.min(dp0, dp1);
    }

    public static void main(String[] args) {
        MinFlipsMonoIncr m = new MinFlipsMonoIncr();
        int i = m.minFlipsMonoIncr("00011000");
    }
}
