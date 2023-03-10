package com.pmb.code.multipointers;

/**
 * https://leetcode.cn/problems/ZVAVXX/submissions/
 * @author lvrui
 */
public class RumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || k == 1) {
            return 0;
        }
        int r = 0;
        int l = 0;
        int multi = 1;
        int cnt = 0;
        while (r < nums.length) {
            multi = nums[r] * multi;
            while (l <= r && multi >= k) {
                multi /= nums[l++];
            }
            cnt += r - l + 1;
            r++;
        }

        return cnt;
    }
}
