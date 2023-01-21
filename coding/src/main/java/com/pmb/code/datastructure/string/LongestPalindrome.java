package com.pmb.code.datastructure.string;

import java.util.Objects;

/**
 * https://blog.csdn.net/kangroger/article/details/37742639
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author lvrui
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        String res = String.valueOf(s.charAt(0));
        int start = 0, end = s.length() - 1;
        int max = 1;
        while (start < end) {
            int innerEnd = s.length() - 1;
            int innerStart = start;
            int length = innerEnd - start;
            if (length <= max) {
                break;
            }
            while (innerStart <= innerEnd) {
                if (s.charAt(innerStart) == s.charAt(innerEnd)) {
                    if (innerEnd - innerStart == 1 || innerEnd - innerStart == 0) {
                        if (length > max) {
                            res = s.substring(start, end + 1);
                            max = length;
                        }
                    }
                    innerEnd--;
                    innerStart++;
                } else {
                    break;
                }
            }
            start++;
        }
        start = 0;
        end = s.length() - 1;

        while (start < end) {
            int innerEnd = s.length() - 1;
            int innerStart = start;
            int length = innerEnd - start;
            if (length <= max) {
                break;
            }
            while (innerStart <= innerEnd) {
                if (s.charAt(innerStart) == s.charAt(innerEnd)) {
                    if (innerEnd - innerStart == 1 || innerEnd - innerStart == 0) {
                        if (length > max) {
                            res = s.substring(start, end);
                            max = length;
                        }
                    }
                    innerEnd--;
                    innerStart++;
                } else {
                    break;
                }
            }
            end--;
        }
        return res;
    }


    public static void main(String[] args) {
        LongestPalindrome.longestPalindrome2("333");
    }

    public static String longestPalindrome2(String s) {
        if (s == null || s.isEmpty() || s.length() < 2) {
            return s;
        }
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int start = 0; start < length; start++) {
            dp[start][start] = 1;
        }
        char[] charArr = s.toCharArray();
        int max = 1;
        String res = String.valueOf(charArr[0]);
        String secondStr = res;
        if (charArr[0] == charArr[1]) {
            dp[0][1] = 1;
            res = s.substring(0, 2);
            secondStr = res;
            max = 2;
        }

        for (int end = 1; end < length; end++) {
            for (int start = 0; start < end; start++) {
                if (charArr[start] == charArr[end]) {
                    if ((dp[start + 1][end - 1] == 1) || start + 1 >= end) {
                        dp[start][end] = 1;
                        int current = end - start + 1;
                        if (current > max) {
                            max = current;
                            secondStr = res;
                            res = s.substring(start, end + 1);
                        }
                    }
                }
            }
        }

        return res.length() == secondStr.length() ? secondStr : res;
    }



    public static String longestPalindrome3(String s) {
        String res = "";
        if (Objects.isNull(s)) {
            return res;
        }
        Integer maxSize = 0;
        for (int indexUp = 0; indexUp <= s.length(); indexUp++) {
            for (int i = indexUp + 1; i <= s.length(); i++) {
                if (((i - indexUp) < maxSize)) {
                    continue;
                }
                if (isMaxMirror(s, indexUp, i)) {
                    String mirror = s.substring(indexUp, i);
                    maxSize = mirror.length();
                    res = mirror;
                }
            }
        }
        return res;
    }

    private static boolean isMaxMirror(String s, int indexUp, Integer index) {

        String mirror = s.substring(indexUp, index);

        for (int i = 0, j = mirror.length() - 1; i < j; i++, j--) {
            String temp1 = String.valueOf(mirror.charAt(i));
            String temp2 = String.valueOf(mirror.charAt(j));
            if (!temp1.equals(temp2)) {
                return false;
            }
        }
        return true;
    }

}
