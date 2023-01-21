package com.pmb.code.datastructure.binarysearch;

/**
 * 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 *
 * @author lvrui
 */
public class Search {
    public int search(int[] nums, int target) {
        return nums == null ? -1 : search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        if (start <= end) {
            int mid = (start + end) >> 1;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                return search(nums, mid + 1, end, target);
            } else {
                return search(nums, start, mid - 1, target);
            }
        }


        return -1;
    }
}
