package com.pmb.wait;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 * <p>
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 *
 * @author lvrui
 */
public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int res = 0;
        int preSum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            preSum = nums[i] == 0 ? --preSum : ++preSum;
            if (preSum == 0 && i + 1 > res) {
                res = i + 1;
            }
            Integer integer = sumMap.get(preSum);
            if (integer == null) {
                sumMap.put(preSum, i);
            } else {
                int length = i - integer;
                res = Math.max(length, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindMaxLength findMaxLength = new FindMaxLength();
        int maxLength = findMaxLength.findMaxLength(new int[]{1, 1, 0});
    }
}
