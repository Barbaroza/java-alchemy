package com.pmb.code.dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/D0F0SV/
 *
 * @author lvrui
 */
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i < target + 1; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    cnt += dp[i - nums[j]];
                } else {
                    break;
                }
            }

            dp[i] = cnt;
        }


        return dp[target];
    }
}
