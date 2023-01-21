package com.pmb.wait;

/**
 * 1567. 乘积为正数的最长子数组长度
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 * <p>
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * <p>
 * 请你返回乘积为正数的最长子数组长度。
 * <p>
 * <p>
 * <p>
 * 示例  1：
 * <p>
 * 输入：nums = [1,-2,-3,4]
 * 输出：4
 * 解释：数组本身乘积就是正数，值为 24 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,-2,-3,-4]
 * 输出：3
 * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
 * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
 * 示例 3：
 * <p>
 * 输入：nums = [-1,-2,-3,0,1]
 * 输出：2
 * 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
 * 示例 4：
 * <p>
 * 输入：nums = [-1,2]
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：nums = [1,2,3,5,-6,4,0,10]
 * 输出：4
 *
 * @author lvrui
 */
public class GetMaxLen {
    public int getMaxLen(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int tempSize = 0;
        int res = 0;
        int[] pMulti = new int[nums.length];
        int[] pSize = new int[nums.length];
        int[] nMulti = new int[nums.length];
        int[] nSize = new int[nums.length];
        if (nums[0] > 0) {
            pMulti[0] = nums[0];
            pSize[0] = 1;
            nMulti[0] = 0;
            pMulti[0] = 0;
            tempSize = 1;
            res = nums[0];
        }
        if (nums[0] < 0) {
            pMulti[0] = 0;
            pSize[0] = 0;
            nMulti[0] = nums[0];
            nSize[0] = 1;
        }


        for (int index = 1; index < nums.length; index++) {
            if (nums[index] > 0) {
                pMulti[index] = pMulti[index - 1] == 0 ? nums[index] : pMulti[index - 1] * nums[index];
                pSize[index] = pSize[index - 1] + 1;
                nMulti[index] = nMulti[index - 1] == 0 ? 0 : nMulti[index - 1] * nums[index];
                nSize[index] = nSize[index - 1] == 0 ? 0 : nSize[index - 1] + 1;
            }
            if (nums[index] < 0) {
                pMulti[index] = nMulti[index - 1] == 0 ? 0 : nMulti[index - 1] * nums[index];
                pSize[index] = nSize[index - 1] == 0 ? 0 : nSize[index - 1] + 1;

                nMulti[index] = pMulti[index - 1] == 0 ? nums[index] : pMulti[index - 1] * nums[index];
                nSize[index] = pSize[index - 1] + 1;
            }
            if (pSize[index] > tempSize) {
                tempSize = pSize[index];
                res = pMulti[index];
            }

        }

        //找0;
        return tempSize;
    }


    public static void main(String[] args) {
        GetMaxLen getMaxLen = new GetMaxLen();
        int maxLen = getMaxLen.getMaxLen(new int[]{0, 1, -2, -3, -4});
    }
}
