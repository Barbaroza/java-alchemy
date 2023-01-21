package com.pmb.wait_2022_11_02;

import java.util.Arrays;

/**
 * LeetCode Logo
 * 题库
 * 0
 * <p>
 * avatar
 * 6236. 不重叠回文子字符串的最大数目
 * 困难
 * 0
 * 相关企业
 * 给你一个字符串 s 和一个 正 整数 k 。
 * <p>
 * 从字符串 s 中选出一组满足下述条件且 不重叠 的子字符串：
 * <p>
 * 每个子字符串的长度 至少 为 k 。
 * 每个子字符串是一个 回文串 。
 * 返回最优方案中能选择的子字符串的 最大 数目。
 * <p>
 * 子字符串 是字符串中一个连续的字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：s = "abaccdbbd", k = 3
 * 输出：2
 * 解释：可以选择 s = "abaccdbbd" 中斜体加粗的子字符串。"aba" 和 "dbbd" 都是回文，且长度至少为 k = 3 。
 * 可以证明，无法选出两个以上的有效子字符串。
 * 示例 2 ：
 * <p>
 * 输入：s = "adbcda", k = 2
 * 输出：0
 * 解释：字符串中不存在长度至少为 2 的回文子字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= s.length <= 2000
 * s 仅由小写英文字母组成
 *
 * @author lvrui
 */
public class MaxPalindromes {
    public int maxPalindromes(String s, int k) {
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0, j = 1; j < length; i++, j++) {
            isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
        }
        for (int i = length - 3; i >= 0; i--) {
            for (int j = i + 2; j < length; j++) {
                isPalindrome[i][j] = (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]);
            }
        }
        int[] shortestPalindromeEnds = new int[length];
        Arrays.fill(shortestPalindromeEnds, -1);
        for (int i = 0, j = k - 1; j < length; i++, j++) {
            for (int end = j; end < length; end++) {
                if (isPalindrome[i][end]) {
                    shortestPalindromeEnds[i] = end;
                    break;
                }
            }
        }
        int[] dp = new int[length + 1];
        for (int i = length - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];
            for (int j = i + k - 1; j < length; j++) {
                if (isPalindrome[i][j]) {
                    dp[i] = Math.max(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }

}
