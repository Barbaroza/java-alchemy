package com.pmb.code.datastructure.array;

import java.util.*;

/**
 * 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * @author lvrui
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int index = 0; index < nums.length; index++) {
            int start = index + 1;
            int end = nums.length - 1;
            while (start < nums.length && start < end) {
                int sum = nums[start] + nums[end] + nums[index];
                if (Math.abs(target - res) > Math.abs(target - sum)) {
                    res = sum;
                }
                if (sum > target) {
                    end--;
                }
                if (sum < target) {
                    start++;
                }
                if(sum == target)
                {
                    return res;
                }
            }
        }

        return res;
    }

}
