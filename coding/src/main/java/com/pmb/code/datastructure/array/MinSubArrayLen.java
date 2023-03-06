package com.pmb.code.datastructure.array;

/**
 * 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * @author lvrui
 * @star
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < n) {
            sum += nums[right];
            right++;
            while (sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;

    }

    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        minSubArrayLen.minSubArrayLen(80, new int[]{10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8});
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int ans = 0;
        if(nums == null || nums.length==0 ){
            return ans;
        }
        ans = Integer.MAX_VALUE;
        int n=nums.length;
        int[][] dp = new int[n][n];

        for(int i = 0;i<n;i++){
            dp[i][i] = nums[i];
            if(nums[i] >= target){
                return 1;
            }
        }

        for(int i = 1;i<n;i++){
            for(int j=0;j<i;j++){
                dp[i][j] = dp[i-1][j]+nums[i];
                if(dp[i][j] >= target){
                    ans = Math.min(ans,i-j+1);
                }
            }
        }

        return Integer.MAX_VALUE == ans? 0:ans;
    }
}
