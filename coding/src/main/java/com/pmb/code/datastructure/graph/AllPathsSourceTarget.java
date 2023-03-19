package com.pmb.code.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/bP4bmD/submissions/
 *
 * @author lvrui
 */
public class AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList();
        List<List<Integer>> ans = new ArrayList();

        dfs(ans, path, 0, graph);

        return ans;
    }


    private void dfs(List<List<Integer>> ans, LinkedList<Integer> path, int node, int[][] graph) {
        if (node == graph.length - 1) {
            path.addLast(node);
            ans.add(new ArrayList(path));
            path.removeLast();
            return;
        }
        path.addLast(node);
        for (int nb : graph[node]) {
            dfs(ans, path, nb, graph);
        }
        path.removeLast();


    }
}
