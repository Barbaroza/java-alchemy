package com.pmb.code.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/Q91FMA/
 *
 * @author lvrui
 */
public class LenLongestFibSubseq {
    int[] dp = null;
    HashMap<Integer, Integer> access = null;

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, max = 0;
        int[][] dp = new int[n][n];
        for(int i = 2 ; i < n ; i++){
            int j = 0, k = i-1;
            while(j < k){
                if(arr[j] + arr[k] == arr[i]){
                    if(dp[j][k] == 0){
                        dp[k][i] = 3;
                    }else{
                        dp[k][i] = Math.max(dp[j][k]+1, dp[k][i]);
                    }
                    max = Math.max(max, dp[k][i]);
                    j++;k--;
                }
                else if(arr[j] + arr[k] < arr[i]){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return max;
    }

    public int lenLongestFibSubseq2(int[] arr) {
        Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            indices.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int k = indices.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                }
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        LenLongestFibSubseq lenLongestFibSubseq = new LenLongestFibSubseq();
        lenLongestFibSubseq.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8});

    }
}
