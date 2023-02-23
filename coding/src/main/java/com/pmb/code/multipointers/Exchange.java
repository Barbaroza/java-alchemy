package com.pmb.code.multipointers;

/**
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/submissions/
 * @author lvrui
 */
public class Exchange {

    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            while (l < r && (nums[l] & 1) == 1) {
                l++;
            }
            while (l < r && (nums[r] & 1) == 0) {
                r--;
            }

            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }

        return nums;
    }


}
