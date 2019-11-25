package com.pmb.code.dp;

public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        int  first = 0;
        int end = 0;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                continue;
            }
            if (nums[i - 1] < nums[i]) {
                end = i;
                max = max > (end - first + 1) ? max : (end - first + 1);
            } else {
                first = i;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLIS.lengthOfLIS(new int []{10,9,2,5,3,7,101,18});
    }
}
