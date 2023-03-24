package com.pmb.code.datastructure.graph;

/**
 * https://leetcode.cn/problems/vEAB3K/submissions/
 *
 * @author lvrui
 */
public class IsBipartite {
    int[] color;
    private static final int C_UNKNOWN = 0;
    private static final int C_1 = 1;
    private static final int C_2 = 2;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        boolean flag = true;
        for (int i = 0; i < n && flag; i++) {
            if (color[i] == C_UNKNOWN) {
                flag = dfs(i, C_1, graph);

            }
        }
        return flag;
    }

    private boolean dfs(int i, int e, int[][] graph) {
        if (color[i] != C_UNKNOWN) {
            if (color[i] != e) {
                return false;
            }
            return true;
        }

        int[] ints = graph[i];
        color[i] = e;
        int target = e == C_1 ? C_2 : C_1;
        boolean flag = true;
        for (int index = 0; index < ints.length && flag; index++) {
            flag = dfs(graph[i][index], target, graph);
        }

        return flag;
    }
}
