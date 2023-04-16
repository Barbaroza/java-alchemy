package com.pmb.code.multipointers;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/smallest-difference-lcci/
 *
 * @author lvrui
 */
public class SmallestDifference {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        long ans = Integer.MAX_VALUE;
        while (i < a.length) {
            while (j < b.length - 1 && b[j] < a[i]) {
                j++;
            }
            if (j > 0) {
                ans = Math.min(ans, Math.abs((long) a[i] - b[j - 1]));
            }
            ans = Math.min(ans, Math.abs((long) a[i] - b[j]));


            i++;
        }

        return (int) ans;
    }

    public int smallestDifference2(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        long ans = Integer.MAX_VALUE;
        while (i < a.length && j < b.length) {

            ans = Math.min(ans, Math.abs((long) a[i] - b[j]));

            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                return 0;
            }


        }

        return (int) ans;
    }

    public static void main(String[] args) {
        SmallestDifference smallestDifference = new SmallestDifference();
        smallestDifference.smallestDifference(new int[]{-2147483648, 1}, new int[]{2147483647, 0});
    }
}
