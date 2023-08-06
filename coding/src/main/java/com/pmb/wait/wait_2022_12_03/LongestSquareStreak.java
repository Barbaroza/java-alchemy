package com.pmb.wait.wait_2022_12_03;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * https://leetcode.cn/contest/weekly-contest-323/problems/longest-square-streak-in-an-array/
 *
 * @author lvrui
 */
public class LongestSquareStreak {

    public int longestSquareStreak(int[] nums) {
        int[] index = new int[100000];
        for (int num : nums) {
            index[num] = 1;
        }

        Arrays.sort(nums);
        int ans = -1;
        for (int n : nums) {
            int cnt = 1;
            int i = n * n;

            while (i <= 100000 && i >= 0 && index[i] == 1) {
                cnt++;
                i *= i;

            }
            ans = Math.max(cnt, ans);
        }

        return ans > 1 ? ans : -1;
    }

}
