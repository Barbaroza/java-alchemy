package com.pmb.code.datastructure.sort;

import java.util.Arrays;

/**
 * 摆动排序 II
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 * <p>
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 * <p>
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 *
 * @author lvrui
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        int[] a = Arrays.copyOfRange(nums, 0, n);
        Arrays.sort(a);
        int k = 0, p = (n - 1) / 2, q = n - 1;
        boolean sign = true;
        //sign控制交替赋值
        while (k < n) {
            if (sign) {
                nums[k++] = a[p--];
            } else {
                nums[k++] = a[q--];
            }
            sign = !sign;
        }

    }

    public void wiggleSort2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        Arrays.sort(nums);
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        boolean switcher = true;
        int start = 0;
        int middle = (nums.length - 1) / 2;
        int end = nums.length - 1;
        while (start < nums.length) {
            if (switcher) {
                nums[start++] = temp[middle--];
            } else {
                nums[start++] = temp[end--];
            }
            switcher = !switcher;
        }
    }

    public static void main(String[] args) {
        WiggleSort sort = new WiggleSort();
        sort.wiggleSort(new int[]{1, 2, 3, 4, 5});
    }
}


