package com.pmb.code.datastructure.string;

/**
 * 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * @author lvrui
 */
public class Search {

    public int search(int[] nums, int target) {
        int res = -1;
        if (nums == null || nums.length < 1) {
            return res;
        }
        int start = 0, end = nums.length - 1;
        res = searchIndex(start, end, nums, target);

        return res;
    }

    private int searchIndex(int start, int end, int[] nums, int target) {
        int res = -1;
        if (start <= end) {
            if (end - start == 1) {
                if (nums[end] == target) {
                    return end;
                }
                if (nums[start] == target) {
                    return start;
                }
                return res;
            } else {
                int mid = (start + end) >> 1;
                if (nums[mid] > target) {
                    if (nums[end] < target) {
                        res = searchIndex(start, mid - 1, nums, target);
                    } else if (nums[end] > target) {
                        if (nums[end] > nums[mid]) {
                            res = searchIndex(start, mid - 1, nums, target);
                        } else {
                            res = searchIndex(mid + 1, end, nums, target);
                        }
                    } else {
                        res = end;
                    }
                } else if (nums[mid] < target) {
                    if (nums[start] > target) {
                        res = searchIndex(mid + 1, end, nums, target);
                    } else if (nums[start] < target) {
                        if (nums[start] < nums[mid]) {

                            res = searchIndex(mid + 1, end, nums, target);
                        } else {
                            res = searchIndex(start, mid - 1, nums, target);
                        }
                    } else {
                        res = start;
                    }
                } else {
                    res = mid;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Search search = new Search();
        search.search(new int[]{5, 1, 3}, 3);
    }
}
