package com.pmb.code.datastructure.array;

/**
 * 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @author lvrui
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int lastMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = max;
            max = Math.max(Math.max(nums[i], nums[i] * tempMax), nums[i] * min);
            min = Math.min(Math.min(nums[i], nums[i] * tempMax), nums[i] * min);
            lastMax = max > lastMax ? max : lastMax;
        }

        return lastMax;
    }

    public static void main(String[] args) {
        MaxProduct m = new MaxProduct();
        m.maxProduct(new int[]{2, 3, -2, 4});
    }
}
