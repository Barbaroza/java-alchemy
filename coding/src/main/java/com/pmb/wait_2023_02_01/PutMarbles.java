package com.pmb.wait_2023_02_01;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-330/problems/put-marbles-in-bags/
 *
 * @author lvrui
 */
public class PutMarbles {

    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        long max = weights[0] + weights[n - 1], min = weights[0] + weights[n - 1];
        long[] tmp = new long[n - 1];
        for (int i = 0; i < n - 1; i++) tmp[i] = weights[i] + weights[i + 1];
        Arrays.sort(tmp);
        for (int i = 0; i < k - 1; i++) {
            max += tmp[n - 2 - i];
            min += tmp[i];
        }
        return max - min;
    }


    public static void main(String[] args) {
        PutMarbles putMarbles = new PutMarbles();
        putMarbles.putMarbles(new int[]{1, 2, 4, 5, 6}, 2);
    }
}
