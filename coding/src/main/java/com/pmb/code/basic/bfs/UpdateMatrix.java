package com.pmb.code.basic.bfs;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/2bCMpM/submissions/
 * @author lvrui
 */
public class UpdateMatrix {
    int[][] move = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean[][] visit = new boolean[m][n];
        int[][] dist = new int[m][n];
        LinkedList<int[]> queue = new LinkedList();
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    visit[i][j] = true;
                    queue.addLast(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.removeFirst();
            int i = cur[0];
            int j = cur[1];

            for (int[] step : move) {
                int ni = i + step[0];
                int nj = j + step[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visit[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1;
                    queue.addLast(new int[]{ni, nj});
                    visit[ni][nj] = true;
                }
            }

        }

        return dist;
    }

    public int[][] updateMatrix2(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[][] dp = new int[m][n];
        for (int[] t : dp) {
            Arrays.fill(t, Integer.MAX_VALUE / 2);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    continue;
                }
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);

                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (dp[i][j] == 0) {
                    continue;
                }
                if (i < m - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j < n - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);

                }
            }
        }
        return dp;

    }

    public static void main(String[] args) {
        UpdateMatrix updateMatrix = new UpdateMatrix();
        updateMatrix.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    }

}
