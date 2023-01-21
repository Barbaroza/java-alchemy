package com.pmb.wait;

/**
 * 1425. 带限制的子序列和
 * 给你一个整数数组 nums 和一个整数 k ，请你返回 非空 子序列元素和的最大值，子序列需要满足：子序列中每两个 相邻 的整数 nums[i] 和 nums[j] ，它们在原数组中的下标 i 和 j 满足 i < j 且 j - i <= k 。
 * <p>
 * 数组的子序列定义为：将数组中的若干个数字删除（可以删除 0 个数字），剩下的数字按照原本的顺序排布。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2,-10,5,20], k = 2
 * 输出：37
 * 解释：子序列为 [10, 2, 5, 20] 。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,-2,-3], k = 1
 * 输出：-1
 * 解释：子序列必须是非空的，所以我们选择最大的数字。
 * 示例 3：
 * <p>
 * 输入：nums = [10,-2,-10,-5,20], k = 2
 * 输出：23
 * 解释：子序列为 [10, -2, -5, 20] 。
 * <p>
 * <p>
 * 提示：
 * ` *
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * @Hard
 * @Star
 * @author lvrui
 */
public class ConstrainedSubsetSum {
    public int constrainedSubsetSum(int[] nums, int k) {

        int tempMax = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; index++) {
            int next = next(nums, index, k);
            System.out.println(next);

            if (next > tempMax) {
                tempMax = next;
            }
        }

        return tempMax;


    }

    public int next(int[] nums, int index, int k) {
        if (index < nums.length) {

            int tempMax = Integer.MIN_VALUE;
            for (int currentIndex = index + 1; currentIndex <= index + k && currentIndex < nums.length; currentIndex++) {
                int currentMax = next(nums, currentIndex, k);
                if (currentMax > tempMax) {
                    tempMax = currentMax;
                }
            }

            return tempMax == Integer.MIN_VALUE ? nums[index] : Math.max(nums[index] + tempMax, nums[index]);
        }

        return 0;

    }


    public static void main(String[] args) {
        ConstrainedSubsetSum subsetSum = new ConstrainedSubsetSum();
        int i = subsetSum.constrainedSubsetSum(new int[]{-1, -2, -3}, 1);
    }
}
