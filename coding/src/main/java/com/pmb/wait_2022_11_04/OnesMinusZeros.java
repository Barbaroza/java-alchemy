package com.pmb.wait_2022_11_04;

/**
 * https://leetcode.cn/contest/biweekly-contest-92/problems/difference-between-ones-and-zeros-in-row-and-column/
 * @author lvrui
 */
public class OnesMinusZeros {
    public int[][] onesMinusZeros(int[][] grid) {
        int nL = grid.length;
        int mL = grid[0].length;
        int[][] res = new int[nL][mL];
        //x - (nl-x) +y-(ml-y) = 2x+2y -nl-ml
        int[] x = new int[nL];
        for (int n = 0; n < nL; n++) {
            int c = 0;
            for (int m = 0; m < mL; m++) {
                if (grid[n][m] == 0) {
                    c++;
                }
            }
            x[n] = c;
        }
        int[] y = new int[mL];

        for (int m = 0; m < mL; m++) {
            int c = 0;
            for (int n = 0; n < nL; n++) {

                if (grid[n][m] == 0) {

                    c++;
                }
            }
            y[m] = c;
        }

        for (int n = 0; n < nL; n++) {
            for (int m = 0; m < mL; m++) {
                res[n][m] = -2 * (x[n] + y[m]) + nL + mL;
            }
        }

        return res;
    }

}
