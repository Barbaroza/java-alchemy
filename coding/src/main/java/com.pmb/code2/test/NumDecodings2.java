package com.pmb.code2.test;

/**
 * 动态规划的本质，是对问题状态的定义和状态转移方程的定义
 * 而拆分问题，靠的就是状态的定义和状态转移方程的定义。
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * @author Administrator
 */
public class NumDecodings2 {
    public static int numDecodings(String s) {

        // 寻找最优子结构和重叠子问题，以记忆化搜索或动态规划来解决
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] codes = s.toCharArray();
        int n = codes.length;
        // memo[i] 表示字符串中第 i 位数字与其之后数字的组成的编码总数
        int[] memo = new int[n];
        if (codes[n - 1] != '0') {
            memo[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            // '0' 需要与其前一位一起考虑，不单独考虑
            if (codes[i] == '0') {
                continue;
            }
            // 判断与后面的数字的组合是否小于 26
            if (codes[i] == '1' || (codes[i] == '2' && codes[i + 1] <= '6')) {
                if (i == n - 2) {
                    memo[i] = memo[i + 1] + 1;
                } else {
                    // 以 i 位数字开头的编码总和其实就是其后两位数字各自的编码之和
                    memo[i] = memo[i + 1] + memo[i + 2];
                }
            } else {
                memo[i] = memo[i + 1];
            }
        }
        return memo[0];
    }



    public static void main(String[] args) {
        NumDecodings2.numDecodings("01");
    }
}
