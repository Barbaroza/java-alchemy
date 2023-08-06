package com.pmb.wait.wait_2022_12_03;

import java.util.Arrays;

/**
 * @author lvrui
 */
public class DeleteGreatestValue {
    public int deleteGreatestValue(int[][] grid) {

        for (int[] a : grid) {
            Arrays.sort(a);
        }

        int ans = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(grid[j][i], max);
            }
            ans += max;
        }




        return ans;
    }
}
