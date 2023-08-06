package com.pmb.wait.wait_2023_02_01;

import com.pmb.code.model.TreeNode;

import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/contest/weekly-contest-330/problems/count-increasing-quadruplets/
 *
 * @author lvrui
 */
public class CountQuadruplets {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        int[][] moreThanJ = new int[n][n + 1];
        int[][] lessThanK = new int[n][n + 1];
        LinkedList<TreeNode> queue = new LinkedList();
        IntStream.range(2, n - 1).forEach(i -> {
            int num = nums[i];
            //copy
            IntStream.range(num, n).forEach(m -> {
                moreThanJ[i][m + 1]++;
            });
        });

        int ans[] = new int[1];
        IntStream.range(1, n - 2).forEach(i -> {
            int num = nums[i];
            IntStream.range(1, num).forEach(m -> {
                lessThanK[i][m]++;

            });

            IntStream.range(i + 1, n - 1).forEach(k -> {
                if (nums[i] > nums[k]) {
                    int rMore = moreThanJ[k][nums[i]];
                    int lLess = lessThanK[i][nums[k]];
                    ans[0] += rMore * lLess;
                }
            });

        });

        return ans[0];

    }


    public static void main(String[] args) {
        CountQuadruplets quadruplets = new CountQuadruplets();

        quadruplets.countQuadruplets(new int[]{1, 3, 2, 4, 5});
    }
}
