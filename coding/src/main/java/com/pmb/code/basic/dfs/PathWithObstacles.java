package com.pmb.code.basic.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/robot-in-a-grid-lcci/
 *
 * @author lvrui
 */
public class PathWithObstacles {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        LinkedList<List<Integer>> path = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        dfs(0, 0, obstacleGrid, path, ans);

        return ans;
    }

    private void dfs(int i, int j, int[][] obstacleGrid, LinkedList<List<Integer>> path, List<List<Integer>> ans) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (obstacleGrid[i][j] == 1) {
            return;
        }
        obstacleGrid[i][j] = 1;
        List<Integer> node = new ArrayList();
        node.add(i);
        node.add(j);
        path.addLast(node);

        if (i == m - 1 && j == n - 1) {
            ans.addAll(path);
            return;
        }

        dfs(i, j + 1, obstacleGrid, path, ans);
        dfs(i + 1, j, obstacleGrid, path, ans);
        path.removeLast();

    }
}
