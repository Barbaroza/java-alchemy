package com.pmb.code.dp;

/**
 * 918
 *
 * @WAIT_SUBMIT
 *
 * @author lvrui
 */
public class MaxSubArraySumCircular {

    public static void main(String[] args) {
        int i = MaxSubArraySumCircular.maxSubArraySumCircular(new int[]{5, 3, -5, 1});
    }

    public static int maxSubArraySumCircular(int[] arr) {
        int pre = 0;
        int res = Integer.MIN_VALUE;
        int[] leftMax = new int[arr.length + 1];
        leftMax[0] = arr[0];
        int lSum = 0;
        for (int i = 0; i < arr.length; i++) {
            pre = Math.max(pre + arr[i], arr[i]);
            res = Math.max(pre, res);
            lSum += arr[i];
            leftMax[i + 1] = Math.max(leftMax[i], lSum);

        }
        int rSum = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            rSum += arr[i];
            res = Math.max(res, rSum + leftMax[i]);


        }

        return res;
    }


}
