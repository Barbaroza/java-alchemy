package com.pmb.wait.wait_2022_12_01;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-322
 *
 * @author lvrui
 */
public class MagnificentSets {
    public int magnificentSets(int n, int[][] edges) {
        Map<Integer, List<Integer>> E = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            E.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            E.get(e[0]).add(e[1]);
            E.get(e[1]).add(e[0]);
        }
        List<List<Integer>> graphs = getSubGraphs(n, E);
        int out = 0;
        for (List<Integer> graph : graphs) {
            int g = -1;
            for (int start : graph) {
                g = Math.max(g, bfs(n, start, E));
            }
            if (g == -1) {
                return -1;
            } else {
                out += g;
            }
        }
        return out;
    }

    private List<List<Integer>> getSubGraphs(int n, Map<Integer, List<Integer>> E) {
        List<List<Integer>> out = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            List<Integer> graph = new ArrayList<>();
            out.add(graph);
            visited[i] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int v = q.remove();
                graph.add(v);
                for (int v2 : E.get(v)) {
                    if (!visited[v2]) {
                        visited[v2] = true;
                        q.add(v2);
                    }
                }
            }
        }
        return out;
    }

    private int bfs(int n, int start, Map<Integer, List<Integer>> E) {
        int[] distance = new int[n + 1];
        distance[start] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int g = 1;
        while (!q.isEmpty()) {
            int v = q.remove();
            int d = distance[v];
            g = Math.max(g, d);
            for (int v2 : E.get(v)) {
                if (distance[v2] == 0) {
                    distance[v2] = d + 1;
                    q.add(v2);
                } else if (distance[v2] != d + 1 && distance[v2] != d - 1) {
                    return -1;
                }
            }
        }
        return g;
    }
}
