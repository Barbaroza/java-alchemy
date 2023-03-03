package com.pmb.code.datastructure.array;

/**
 * https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/comments/
 *
 * @author lvrui
 */
public class ConstructArr {
    public int[] constructArr(int[] a) {
        int[] left = new int[a.length + 1];
        int[] right = new int[a.length + 1];
        int[] ans = new int[a.length];

        for (int i = 0; i < a.length + 1; i++) {
            left[i] = i > 0 ? left[i - 1] * a[i - 1] : 1;
        }
        for (int i = a.length; i >= 0; i--) {
            right[i] = i < a.length ? right[i + 1] * a[i] : 1;
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = left[i] * right[i + 1];
        }

        return ans;
    }
}
