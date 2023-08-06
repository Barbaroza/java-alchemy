package com.pmb.wait.wait_2022_11_02;

/**
 * https://leetcode.cn/contest/weekly-contest-319/problems/number-of-subarrays-with-lcm-equal-to-k/
 * 6234. 最小公倍数为 K 的子数组数目
 * 中等
 * 0
 * 相关企业
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 nums 的 子数组 中满足 元素最小公倍数为 k 的子数组数目。
 *
 * 子数组 是数组中一个连续非空的元素序列。
 *
 * 数组的最小公倍数 是可被所有数组元素整除的最小正整数。
 *
 *
 *
 * 示例 1 ：
 *
 * 输入：nums = [3,6,2,7,1], k = 6
 * 输出：4
 * 解释：以 6 为最小公倍数的子数组是：
 * - [3,6,2,7,1]
 * - [3,6,2,7,1]
 * - [3,6,2,7,1]
 * - [3,6,2,7,1]
 * 示例 2 ：
 *
 * 输入：nums = [3], k = 2
 * 输出：0
 * 解释：不存在以 2 为最小公倍数的子数组。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i], k <= 1000
 * @author lvrui
 */
public class SubarrayLCM {
    public int subarrayLCM(int[] nums, int k) {
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int multiple = nums[i];
            if (multiple == k) {
                count++;
            }
            for (int j = i + 1; j < length; j++) {
                multiple = lcm(multiple, nums[j]);
                if (multiple == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int lcm(int num1, int num2) {
        return num1 * num2 / gcd(num1, num2);
    }

    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}
