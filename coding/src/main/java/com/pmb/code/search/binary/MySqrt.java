package com.pmb.code.search.binary;

/**
 * https://leetcode.cn/problems/jJ0w9p/
 *
 * @author lvrui
 */
public class MySqrt {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        while (l <= r) {
            int mid = r + ((l - r) >> 1);
            if (mid * mid > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
