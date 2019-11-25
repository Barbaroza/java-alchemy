package com.pmb.code.datastructure.array;

/**
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 数学表达式如下:
 * <p>
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [5,4,3,2,1]
 * 输出: false
 *
 * @author lvrui
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int minValue = nums[0];
        int maxValue = getMax(nums, 1);
        for (int i = 1; i < nums.length; i++) {
            if (maxValue > nums[i] && minValue < nums[i]) {
                return true;
            } else {
                minValue = Math.min(minValue, nums[i]);
                if (i + 1 <= nums.length - 1 && nums[i + 1] >= maxValue) {
                    maxValue = getMax(nums, i + 1);
                }
            }
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int minest = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= minest) {
                minest = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            } else if (nums[i] > secondMin) {
                return true;
            }
        }
        return false;
    }

    private int getMax(int[] nums, int i) {
        int max = nums[nums.length - 1];
        for (int d = i + 1; d < nums.length; d++) {
            max = Math.max(max, nums[d]);
        }
        return max;
    }

    public static void main(String[] args) {
        IncreasingTriplet a = new IncreasingTriplet();
        boolean b = a.increasingTriplet2(new int[]{0, 4, 2, 1, 0, -1, -3});
    }
}
