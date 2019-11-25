package com.pmb.code2.test;

import java.util.Objects;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author Administrator
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Integer res = 0;
        if (Objects.isNull(s)) {
            return res;
        }
        int begin = 0;
        StringBuilder resSet = new StringBuilder();
        for (int indexUp = 1; indexUp <= s.length(); indexUp++) {
            String next = s.substring(indexUp - 1, indexUp);

            if (!resSet.toString().contains(next)) {
                resSet.append(next);
                res = res > resSet.length() ? res : resSet.length();
            } else {
                String subStr = s.substring(begin, indexUp - 1);
                int indexNext = subStr.lastIndexOf(next);
                begin = indexNext + begin;
                resSet = new StringBuilder(subStr.substring(indexNext));

            }
            System.out.println(resSet);

        }
        System.out.println(res);

        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring.lengthOfLongestSubstring("aabaabc");
    }
}
