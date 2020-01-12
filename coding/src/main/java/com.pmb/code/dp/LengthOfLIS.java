package com.pmb.code.dp;

/**
 * @star
 */
public class LengthOfLIS {


    public static int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(dp[i], result);
        }

        return result;
    }


    public int lengthOfLIS3(int[] nums) {
        int[] dp = new int[nums.length];
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (result == -1 || dp[result] < nums[i]) {
                result++;
                dp[result] = nums[i];
            } else {
                int index = this._binarySearch(dp, 0, result, nums[i]);
                dp[index] = nums[i];
                result = Math.max(result, index);
            }
        }

        return result + 1;
    }

    private int _binarySearch(int[] nums, int head, int tail, int target) {
        while (head <= tail) {
            int mid = (head + tail) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                head = mid + 1;
            } else {
                tail = mid - 1;
            }
        }

        return head;
    }


    public static void main(String[] args) {
        LengthOfLIS.lengthOfLIS2(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }
}
