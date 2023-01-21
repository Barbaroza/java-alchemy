package com.pmb.code.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 *
 * @author lvrui
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }

    }

    public int numIslands2(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<Node> stack = new LinkedList<>();
        stack.add(new Node(i, j));
        while (!stack.isEmpty()) {
            Node pop = stack.remove();
            if (pop.i >= 0 && pop.i < grid.length && pop.j >= 0 && pop.j < grid[pop.i].length && grid[pop.i][pop.j] == '1') {
                grid[pop.i][pop.j] = '0';
                stack.add(new Node(pop.i + 1, pop.j));
                stack.add(new Node(pop.i - 1, pop.j));
                stack.add(new Node(pop.i, pop.j + 1));
                stack.add(new Node(pop.i, pop.j - 1));
            }
        }
    }

    class Node {
        int i;
        int j;

        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }


}
