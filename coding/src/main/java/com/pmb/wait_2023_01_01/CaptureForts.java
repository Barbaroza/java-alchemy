package com.pmb.wait_2023_01_01;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximum-enemy-forts-that-can-be-captured/
 *
 * @author lvrui
 */
public class CaptureForts {
    public int captureForts(int[] forts) {
        int ans = 0;
        int[] w = new int[forts.length];
        int[] v = new int[forts.length];

        Arrays.fill(v, -2);
        int index = -1;
        int pre = -2;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] != pre) {
                pre = forts[i];
                index++;
                v[index] = pre;
            }
            w[index]++;

        }
        for (int i = 0; i < v.length; i++) {
            if (v[i] == 0 && i != 0 && i != v.length - 1) {
                if (v[i - 1] == -1 && v[i + 1] == 1) {
                    ans = Math.max(ans, w[i]);
                }

                if (v[i + 1] == -1 && v[i - 1] == 1) {
                    ans = Math.max(ans, w[i]);
                }
            }
        }
        return ans;
    }
}
