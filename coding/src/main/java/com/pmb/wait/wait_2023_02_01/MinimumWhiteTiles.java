package com.pmb.wait.wait_2023_02_01;

/**
 * https://leetcode.cn/problems/minimum-white-tiles-after-covering-with-carpets/
 *
 * @author lvrui
 */
public class MinimumWhiteTiles {

    public int minimumWhiteTiles(String floor, int n, int carpetLen) {
        int m = floor.length();
        if (n * carpetLen >= m) return 0; // 剪枝
        int[][] f = new int[n + 1][m];
        f[0][0] = floor.charAt(0) % 2;
        for (int i = 1; i < m; ++i)
            f[0][i] = f[0][i - 1] + floor.charAt(i) % 2;
        for (int i = 1; i <= n; ++i)
            // j < carpetLen * i 的 f[i][j] 均为 0
            for (int j = carpetLen * i; j < m; ++j)
                f[i][j] = Math.min(f[i][j - 1] + floor.charAt(j) % 2, f[i - 1][j - carpetLen]);
        return f[n][m - 1];
    }


}
