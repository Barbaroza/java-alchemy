package com.pmb.code.bitwise;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/by-en-xiao-06he/
 *
 * @author lvrui
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int[] a = new int[32];

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                a[i] = (1 & (num >> i)) == 1 ? a[i] + 1 : a[i];
            }
        }
        int res = 0;

        for (int i = 0; i < 32; i++) {
            res |= (a[i] % 3) << i;
        }
        return res;
    }
}

