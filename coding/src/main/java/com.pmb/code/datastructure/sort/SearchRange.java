package com.pmb.code.datastructure.sort;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * @author lvrui
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length < 1) {
            return res;
        }
        if (target < nums[0] | target > nums[nums.length - 1]) {
            return res;
        }
        int start = 0, end = nums.length;
        while (start < end) {
            int middle = (start + end) / 2;
            if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle;
            }

        }

        if (nums[start] == target) {
            int index = start;
            while (index >= start) {
                if (nums[index] == target) {
                    res[0] = index;
                    index--;
                } else {
                    break;
                }
            }
            index = start;
            while (index < nums.length) {
                if (nums[index] == target) {
                    res[1] = index;
                    index++;
                } else {
                    break;
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
}

