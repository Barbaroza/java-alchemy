package com.pmb.code.datastructure.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/tvdfij/solution/zuo-you-liang-bian-zi-shu-zu-de-he-xiang-5j4r/
 * @author lvrui
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int sumLeft = 0;
        int sumRight = sum;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                sumLeft += nums[i - 1];
            }
            sumRight -= nums[i];
            if (sumLeft == sumRight) {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

}
