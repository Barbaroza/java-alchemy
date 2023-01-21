package com.pmb.code.datastructure.array;

/**
 * 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 * @author lvrui
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        for (int start = 0; start < nums.length; start++) {
            while (start < nums.length && nums[start] != 1) {
                start++;
            }
            if (nums.length - start - 1 < res) {
                break;
            }
            int temp = start + 1;
            while (temp < nums.length && nums[temp] == 1) {
                temp++;
            }
            res = Math.max(res, temp - start);
            start = temp - 1;

        }
        return res;
    }

    public static void main(String[] args) {
        FindMaxConsecutiveOnes findMaxConsecutiveOnes = new FindMaxConsecutiveOnes();
        findMaxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{0, 1, 1, 0});
    }
}
