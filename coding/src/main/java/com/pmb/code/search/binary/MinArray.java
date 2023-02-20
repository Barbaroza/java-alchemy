package com.pmb.code.search.binary;

/**
 * https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * @author lvrui
 */
public class MinArray {

    public int minArray(int[] numbers) {
        //iteration
        return binSearch(numbers);
        //binSearch
    }


    private int iteration(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int l = nums.length;
        if (l == 1) {
            return nums[0];
        } else if (l == 2) {
            return Math.min(nums[1], nums[0]);
        } else {
            for (int i = 1; i < l - 1; i++) {
                if (nums[i] < nums[i - 1] && nums[i] <= nums[i + 1]) {
                    return nums[i];
                }
            }

            return Math.min(nums[0], nums[l - 1]);
        }

    }

    private int binSearch(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = r - (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r--;
            }
        }


        return nums[l];
    }

    public static void main(String[] args) {
        MinArray minArray = new MinArray();
        minArray.minArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }
}
