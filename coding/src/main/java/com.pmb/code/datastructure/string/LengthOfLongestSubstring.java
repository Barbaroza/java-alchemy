package com.pmb.code.datastructure.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
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
 * @author lvrui
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s == null || s.isEmpty()) {
            return res;
        }
        int start = 0;
        Set<String> uniqueSet = new HashSet<>();
        char c = s.charAt(start);
        res = 1;
        uniqueSet.add(String.valueOf(c));
        int end = start;
        while (start <= end && end + 1 < s.length()) {
            end++;
            if (uniqueSet.add(String.valueOf(s.charAt(end)))) {
                int size = uniqueSet.size();
                res = res > size ? res : size;
            } else {
                while (start <= end) {
                    if (s.charAt(start) == s.charAt(end)) {
                        start++;
                        break;
                    } else {
                        uniqueSet.remove(String.valueOf(String.valueOf(s.charAt(start))));
                        start++;

                    }
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {
        lengthOfLongestSubstring("wwww");


    }
}
