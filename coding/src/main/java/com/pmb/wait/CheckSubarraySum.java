package com.pmb.wait;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * <p>
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * 示例 3：
 * <p>
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 *
 * @author lvrui
 */
public class CheckSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = i > 0 ? sum[i - 1] + nums[i] : nums[i];
            if (i > 0 && sum[i] % k == 0) {
                return true;
            }
        }
        for (int j = 2; j < nums.length; j++) {
            for (int i = 0; i + j < nums.length; i++) {
                if ((sum[i + j] - sum[i]) % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int preRemainder = 0;
        Map<Integer, Integer> remainderMap = new HashMap<>(k);
        for (int i = 0; i < nums.length; i++) {

            int remainder = (nums[i] + preRemainder) % k;
            preRemainder = remainder;
            if (i > 0 && remainder == 0) {
                return true;
            }
            Integer index = remainderMap.get(remainder);
            if (index != null) {
                if (i - index > 1) {
                    return true;
                }
            } else {
                remainderMap.put(remainder, i);
            }


        }
        return false;
    }

    public static void main(String[] args) {
        CheckSubarraySum checkSubarraySum = new CheckSubarraySum();
        checkSubarraySum.checkSubarraySum2(new int[]{
                        50000000, 50000000

                }
                , 100000000);
    }
}
