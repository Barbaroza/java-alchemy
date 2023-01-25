package com.pmb.wait_2023_01_02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/minimum-cost-to-split-an-array/
 * @author lvrui
 */
public class MinCost {
    public int minCost(int[] nums, int k) {




        return 0;
    }

//    function minCost(nums: number[], k: number): number {
//    const f = [k];
//        f[-1] = 0;
//        for (let i = 1; i < nums.length; i++) {
//            f[i] = f[i - 1] + k;
//        const map = {};
//            let cnt = 0;
//            for (let j = i; j >= 0; j--) {
//                map[nums[j]] = (map[nums[j]] ?? 0) + 1;
//                if (map[nums[j]] > 1) {
//                    cnt++;
//                    if (map[nums[j]] === 2) cnt++;
//                }
//                f[i] = Math.min(f[i], f[j - 1] + k + cnt);
//            }
//        }
//        return f[nums.length - 1];
//    };


    public int minCost1(int[] nums, int k) {
        int n = nums.length;
        int[][] t = new int[n][n];
        for (int i = 0; i < n; i++) {
            // 只出现一次的
            Set<Integer> set = new HashSet();
            // 出现两次及以上的
            Set<Integer> has = new HashSet();
            int cnt = 0;
            t[i][i] = 0;
            set.add(nums[i]);
            for (int j = i + 1; j < n; j++) {
                if (has.contains(nums[j])) {
                    t[i][j] = t[i][j - 1] + 1;
                } else {
                    if (set.contains(nums[j])) {
                        t[i][j] = t[i][j - 1] + 2;
                        set.remove(nums[j]);
                        has.add(nums[j]);
                    } else {
                        t[i][j] = t[i][j - 1];
                        set.add(nums[j]);
                    }
                }
            }
        }
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + k + t[j][i - 1]);
            }
        }
        return (int) dp[n];
    }
}
