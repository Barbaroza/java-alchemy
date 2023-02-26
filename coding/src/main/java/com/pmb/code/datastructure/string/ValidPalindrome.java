package com.pmb.code.datastructure.string;

/**
 * https://leetcode.cn/problems/RQku0D/solution/zui-duo-shan-chu-yi-ge-zi-fu-de-dao-hui-30b55/
 *
 * @author lvrui
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            r--;
            l++;

        }

        return isValid(s, l + 1, r) || isValid(s, l, r - 1);

    }

    private boolean isValid(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
