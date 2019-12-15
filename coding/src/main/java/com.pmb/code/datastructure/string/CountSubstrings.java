package com.pmb.code.datastructure.string;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 * <p>
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 * <p>
 * 输入的字符串长度不会超过1000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lvrui
 */
public class CountSubstrings {


    /**
     * 暴力法
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int res = 0;
        if (s == null || s.isEmpty()) {
            return res;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int n = i; n < chars.length; n++) {
                res = res + isSub(chars, i, n);
            }
        }
        return res;
    }

    private int isSub(char[] chars, int i, int n) {
        while (i <= n) {
            if (chars[i] != chars[n]) {
                return 0;

            }
            i++;
            n--;
        }

        return 1;
    }

    /**
     * 中心扩展法
     *
     * @param s
     * @return
     */
    public int countSubstrings2(String s) {
        int res = 0;
        if (s == null || s.isEmpty()) {
            return res;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            res = res + fromMid(chars, i, i);
            res = res + fromMid(chars, i, i + 1);
        }
        return res;
    }

    private int fromMid(char[] chars, int left, int right) {
        int count = 0;
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public int countSubstrings3(String s) {
        int res = 0;
        if (s == null || s.isEmpty()) {
            return res;
        }
        char[] chars = s.toCharArray();
        int i;
        int j;
        boolean current;
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int index = 0; index < chars.length; index++
        ) {
            res++;
            dp[index][index] = true;
        }
        for (i = 1; i < chars.length; i++) {
            for (j = 0; j < i; j++) {
                current = s.charAt(j) == s.charAt(i);
                if (current && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    res++;
                }
            }

        }


        return res;
    }


    public static void main(String[] args) {
        CountSubstrings c = new CountSubstrings();
        c.countSubstrings2("abc");
    }

}
