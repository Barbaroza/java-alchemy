package com.pmb.wait;

import java.util.Objects;

/**
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
 * @author Administrator
 * @wait-v
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
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
    public static String longestPalindrome3(String s) {
        int max = 0;
        String maxPal = "";
        for (int i = 0; i < s.length(); i++) {
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > max) {
                        max = r - l + 1;
                        maxPal = s.substring(l, r + 1);
                    }
                } else {
                    break;
                }
                r++;
                l--;
            }
            int a = i-1;
            int b = i;
            while (a >= 0 && b < s.length()) {
                if(s.charAt(a) == s.charAt(b)){
                    if (b - a + 1 > max) {
                        max = b - a + 1;
                        maxPal = s.substring(a, b + 1);
                    }
                }else {
                    break;
                }
                a--;
                b++;
            }
        }

        return maxPal;
    }

    public static void main(String[] args) {
        LongestPalindrome.longestPalindrome("ababcbaasd");
    }
}
