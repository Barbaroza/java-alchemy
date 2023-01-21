package com.pmb.code.datastructure.array;

/**
 * 除自身以外数组的乘积
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * @author lvrui
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length];
        int[] right = new int[nums.length];
        int[] left = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                right[i] = nums[i];
            } else {
                right[i] = nums[i] * right[i - 1];
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                left[i] = nums[i];
            } else {
                left[i] = nums[i] * left[i + 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[i] = left[i + 1];
            } else if (i == nums.length - 1) {
                res[i] = right[i - 1];
            } else {
                res[i] = right[i - 1] * left[i + 1];
            }

        }

        return res;
    }
}
