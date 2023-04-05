package com.pmb.code.datastructure.array;

/**
 * https://leetcode.cn/problems/rotate-matrix-lcci/
 *
 * @author lvrui
 */
public class Rotate2 {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int trem = ((n + 1) >> 1);

        for (int i = 0; i <= trem; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                // (x,y) -> (y,n-x-1)
                int ni = i;
                int nj = j;
                int pre = matrix[ni][nj];
                int cnt = 4;
                while (cnt > 0) {
                    int t = ni;
                    ni = nj;
                    nj = n - 1 - t;
                    int tv = matrix[ni][nj];
                    matrix[ni][nj] = pre;
                    pre = tv;
                    cnt--;
                }
            }
        }


    }


    public static void main(String[] args) {
        Rotate2 rotate2 = new Rotate2();
        rotate2.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
