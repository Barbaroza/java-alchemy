package com.pmb.code.datastructure.array;

/**
 * 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 *
 * @author lvrui
 */
public class FindLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        if (nums == null || nums.length == 0) {
            return max;
        }
        max = 1;
        int temp = 1;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index - 1] < nums[index]) {
                temp++;
                max = Math.max(max, temp);
            } else {
                temp = 1;
            }
        }
        return max;
    }
}
