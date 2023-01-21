package com.pmb.wait_2022_11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvrui
 */
public class MaximumSubarraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long t = 0;
        for (int i = 0; i < k - 1; i++) {
            map.compute(nums[i], (p, v) -> v == null ? 1 : v + 1);
            t += nums[i];
        }
        long ret = 0;
        for (int i = k - 1; i < nums.length; i++) {
            map.compute(nums[i], (p, v) -> v == null ? 1 : v + 1);
            t += nums[i];
            if (map.size() == k) {
                ret = Math.max(ret, t);
            }
            map.compute(nums[i - k + 1], (p, v) -> v - 1);
            if (map.get(nums[i - k + 1]) == 0) {
                map.remove(nums[i - k + 1]);
            }
            t -= nums[i - k + 1];
        }
        return ret;
    }


    public static void main(String[] args) {
        MaximumSubarraySum maximumSubarraySum = new MaximumSubarraySum();
        long l = maximumSubarraySum.maximumSubarraySum(new int[]{1, 1, 1, 7, 8, 9}, 3);
    }
}
