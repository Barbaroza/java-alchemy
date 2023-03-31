package com.pmb.code.basic.prefix;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/cuyjEf/
 *
 * @author lvrui
 */
public class Solution1 {
    int[] pre;
    int total;

    public Solution1(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; ++i) {
            pre[i] = pre[i - 1] + w[i];
        }
        total = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        int x = (int) (Math.random() * total) + 1;
        return binarySearch(x);
    }

    private int binarySearch(int x) {
        int l = 0;
        int r = pre.length - 1;
        while (l < r) {
            int mid = r - ((r - l) >>> 1);
            if (pre[mid] < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }


}
