package com.pmb.code.dp;

/**https://leetcode.cn/problems/PzWKhm/submissions/
 * @author lvrui
 */
public class Rob2 {
    public int rob(int[] nums) {
        if(nums.length ==1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int max = nums[0];
        int first = nums[0];
        int second = nums[0];
        for(int i =2;i<nums.length-1;i++){
            max = Math.max(nums[i]+first,second);
            first = second;
            second = max;
        }

        int max2 = nums[1];
        first = 0;
        second = nums[1];
        for(int i =2;i<nums.length;i++){
            max2 = Math.max(nums[i]+first,second);
            first = second;
            second = max2;
        }

        return Math.max(max,max2);
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, n - 1), robRange(nums, 1, n));
    }

    public int robRange(int[] nums, int start, int end) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end - 1];
    }
    private int rob1(int[] nums, int start, int end) { // [start,end)
        int f0 = 0, f1 = 0;
        for (int i = start; i < end; ++i) {
            int newF = Math.max(f1, f0 + nums[i]);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }

    public int rob3(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0] + rob1(nums, 2, n - 1), rob1(nums, 1, n));
    }



}
