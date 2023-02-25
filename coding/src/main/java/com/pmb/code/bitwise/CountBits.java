package com.pmb.code.bitwise;

/**
 * https://leetcode.cn/problems/w3tCBm/submissions/
 * @author lvrui
 */
public class CountBits {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = bitCount(i);

        }
        return ans;
    }

    private int bitCount(int i) {
        int cnt = 0;
        while (i != 0) {
            if ((i & 1) == 1) {
                cnt++;
            }
            i >>= 1;
        }
        return cnt;
    }

    public int[] countBits2(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}