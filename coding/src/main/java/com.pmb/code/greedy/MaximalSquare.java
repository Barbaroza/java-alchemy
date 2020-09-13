package com.pmb.code.greedy;

/**
 * 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输出: 4
 *
 * @author lvrui
 */
public class MaximalSquare {


    /**
     * 暴力法
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int n = 0; n < matrix[0].length; n++) {
                res = Math.max(res, getRes(i, n, matrix, res));
            }
        }

        return res * res;
    }

    private int getRes(int i, int n, char[][] matrix, int res) {
        int currentRes = 0;
        if (matrix[i][n] == '0') {
            return currentRes;
        }
        currentRes = 1;
        if (i + res >= matrix.length || n + res >= matrix[0].length) {
            return currentRes;
        }
        for (int length = i + 1, width = n + 1; length < matrix.length && width < matrix[0].length; length++, width++) {
            boolean flag = true;

            int tempLength = length;
            while (flag && tempLength >= i) {
                if (matrix[tempLength--][width] != '1') {
                    flag = false;
                }
            }
            int tempWitdh = width;
            while (flag && tempWitdh >= n) {
                if (matrix[length][tempWitdh--] != '1') {
                    flag = false;
                }
            }
            if (flag) {
                currentRes++;
            } else {
                break;
            }
        }

        return currentRes;
    }

    public int maximalSquare2(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        maximalSquare.maximalSquare(new char[][]{new char[]{'0', '0', '0', '1'},
                new char[]{'1', '1', '0', '1'},
                new char[]{'1', '1', '1', '1'},
                new char[]{'0', '1', '1', '1'},
                new char[]{'0', '1', '1', '1'}});
    }

}
