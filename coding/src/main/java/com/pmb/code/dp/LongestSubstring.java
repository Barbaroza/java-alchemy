package com.pmb.code.dp;

/**
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aaabb", k = 3
 * <p>
 * 输出:
 * 3
 * <p>
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 * <p>
 * 输入:
 * s = "ababbc", k = 2
 * <p>
 * 输出:
 * 5
 * <p>
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 * @author lvrui
 */
public class LongestSubstring {

    public int longestSubstring(String s, int k) {
        if (k <= 1)
            return s.length();
        char[] arr = s.toCharArray();
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] mip = new int[26];
            mip[arr[i] - 'a']++;
            for (int j = i + 1; j < arr.length; j++) {
                mip[arr[j] - 'a']++;
                if (arrBiggerK(mip, k) == true && j - i + 1 > size) {
                    size = j - i + 1;
                }
            }
        }
        return size;
    }

    private boolean arrBiggerK(int[] arr, int k) {
        for (int c : arr) {
            if (c > 0 && c < k) {
                return false;
            }
        }
        return true;
    }
}
