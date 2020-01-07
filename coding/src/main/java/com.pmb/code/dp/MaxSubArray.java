package com.pmb.code.dp;

import java.util.Arrays;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author lvrui
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0) {
            return res;
        }
        int[] dp = Arrays.copyOf(nums, nums.length);
        res = dp[0];
        for (int index = 1; index < nums.length; index++) {
            dp[index] = Math.max(nums[index], nums[index] + dp[index - 1]);
            res = Math.max(res, dp[index]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
