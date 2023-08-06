package com.pmb.fast;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/
 *
 * @author lvrui
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        int[] arr = new int[nums.length];

        for (int num : nums) {
            if (arr[num] > 0) {
                return num;
            } else {
                arr[num]++;
            }
        }

        return -1;

    }

}
