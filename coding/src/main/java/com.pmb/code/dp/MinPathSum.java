package com.pmb.code.dp;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lvrui
 */
public class MinPathSum {
    /**
     * 时间复杂度 mn
     * 空间复杂度 1
     * 二维dp
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int res = 0;
        if (grid != null && grid.length > 0) {
            int length = grid.length;
            int width = grid[0].length;
            int currentLengthIndex = 0, currentWidthIndex = 0;
            while (currentLengthIndex < length && currentWidthIndex < width) {
                for (int i = currentLengthIndex; i < length; i++) {

                    if (i == 0 && currentWidthIndex != 0) {
                        grid[i][currentWidthIndex] = grid[i][currentWidthIndex]
                                + grid[i][currentWidthIndex - 1];
                    } else if (i == 0 && currentWidthIndex == 0) {
                        grid[i][currentWidthIndex] = grid[i][currentWidthIndex];

                    } else if (i != 0 && currentWidthIndex == 0) {
                        grid[i][currentWidthIndex] = grid[i][currentWidthIndex]
                                + grid[i - 1][currentWidthIndex];
                    } else {
                        grid[i][currentWidthIndex] = grid[i][currentWidthIndex]
                                + Math.min(grid[i][currentWidthIndex - 1], grid[i - 1][currentWidthIndex]);
                    }
                }
                for (int i = currentWidthIndex + 1; i < width; i++) {
                    if (i == 0 && currentLengthIndex != 0) {
                        grid[currentLengthIndex][i] = grid[currentLengthIndex][i]
                                + grid[currentLengthIndex - 1][i];
                    } else if (i == 0 && currentLengthIndex == 0) {
                        grid[currentLengthIndex][i] = grid[currentLengthIndex][i];
                    } else if (i != 0 && currentLengthIndex == 0) {
                        grid[currentLengthIndex][i] = grid[currentLengthIndex][i]
                                + grid[currentLengthIndex][i - 1];
                    } else {
                        grid[currentLengthIndex][i] = grid[currentLengthIndex][i]
                                + Math.min(grid[currentLengthIndex][i - 1], grid[currentLengthIndex - 1][i]);
                    }

                }
                currentLengthIndex++;
                currentWidthIndex++;
            }
            res = grid[length - 1][width - 1];
        }

        return res;
    }

    /**
     * 一维dp
     *
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1)
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                else if (j == grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                else if (j != grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }

    /**
     * [[1,3,1],[1,5,1],[4,2,1]]
     *
     * @param args
     */
    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
        minPathSum.minPathSum(new int[][]{new int[]{1, 3, 1},
                new int[]{1, 5, 1}, new int[]{4, 2, 1}});
    }
}
