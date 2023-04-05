package com.pmb.code.datastructure.array;

/**
 * https://leetcode.cn/problems/zero-matrix-lcci/solution/
 *
 * @author lvrui
 */
public class SetZeroes {
    int m;
    int n;

    public void setZeroes(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        boolean[][] visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] || matrix[i][j] != 0) {
                    continue;
                }
                transfer(visit, i, j, matrix);
            }
        }
    }


    private void transfer(boolean[][] visit, int i, int j, int[][] matrix) {
        if (i < 0 || i >= m || j < 0 || j >= n || visit[i][j]) {
            return;
        }
        visit[i][j] = true;

        for (int a = 0; a < m; a++) {
            if (visit[a][j]) {
                continue;
            }
            if (matrix[a][j] == 0) {
                transfer(visit, a, j, matrix);

            }
            if (matrix[a][j] != 0) {
                matrix[a][j] = 0;
            }
            visit[a][j] = true;

        }
        for (int b = 0; b < n; b++) {
            if (visit[i][b]) {
                continue;
            }
            if (matrix[i][b] == 0) {
                transfer(visit, i, b, matrix);

            }
            if (matrix[i][b] != 0) {
                matrix[i][b] = 0;
            }
            visit[i][b] = true;

        }

    }
}
