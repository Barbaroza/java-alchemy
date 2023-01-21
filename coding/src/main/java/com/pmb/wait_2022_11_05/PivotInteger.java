package com.pmb.wait_2022_11_05;

/**
 * https://leetcode.cn/contest/weekly-contest-321/problems/find-the-pivot-integer/
 *
 * @author lvrui
 */
public class PivotInteger {

    public int pivotInteger(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return -1;
        }

        int i = 1, j = n;
        int ans = -1;
        int preSum = 0;
        int sufSum = 0;
        preSum += i;
        sufSum += j;
        while (i <= j) {

            if (preSum > sufSum) {
                j--;
                sufSum += j;

            } else if (preSum < sufSum) {
                i++;
                preSum += i;

            } else {
                if (i == j - 2) {
                    return j - 1;
                }
                i++;
                preSum += i;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PivotInteger p = new PivotInteger();
        int i = p.pivotInteger(8);
    }
}
