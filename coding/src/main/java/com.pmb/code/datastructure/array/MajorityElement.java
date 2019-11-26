package com.pmb.code.datastructure.array;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @author lvrui
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int tempCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                tempCount++;
            } else {
                tempCount--;
                if (tempCount == 0) {
                    res = nums[i];
                    tempCount++;
                }
            }
        }
        return res;
    }

    /**
     * 先sort排下序，然后取最中间的那个数因为定义的是个数大于数组长度的二分之一
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        m.majorityElement(new int[]{3, 2, 3});
    }
}
