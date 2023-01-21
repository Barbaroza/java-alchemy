package com.pmb.code.datastructure.array;

/**
 * 岛屿的最大面积
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * <p>
 * 示例 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 * <p>
 * 示例 2:
 * <p>
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 * <p>
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 * @author lvrui
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        Integer res = 0;
        if (grid == null) {
            return res;
        }

        for (int length = 0; length < grid.length; length++) {
            for (int width = 0; width < grid[0].length; width++) {
                int temp = dfs(grid, length, width);
                res = res < temp ? temp : res;
            }
        }
        return res;
    }

    private Integer dfs(int[][] grid, int length, int width) {
        int res = 0;
        if (length < 0 || length >= grid.length || width < 0 || width >= grid[0].length) {
            return res;
        }
        try {
            if (grid[length][width] == 1) {
                res++;
                grid[length][width] = 0;
                res = res + dfs(grid, length - 1, width);
                res = res + dfs(grid, length + 1, width);
                res = res + dfs(grid, length, width - 1);
                res = res + dfs(grid, length, width + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int[] ints = {1, 2, 3};

        maxAreaOfIsland.maxAreaOfIsland(new int[][]{new int[]{1, 1, 0, 0, 0},
                new int[]{1, 1, 0, 0, 0},
                new int[]{0, 0, 0, 1, 1},
                new int[]{1, 1, 0, 1, 1}});
    }
}
