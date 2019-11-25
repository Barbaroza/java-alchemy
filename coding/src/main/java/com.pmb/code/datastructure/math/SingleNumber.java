package com.pmb.code.datastructure.math;

/**
 * @author lvrui
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        return temp;
    }
}
