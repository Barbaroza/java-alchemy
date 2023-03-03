package com.pmb.code.bitwise;

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
