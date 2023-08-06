package com.pmb.wait.wait_2022_12_01;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-322/problems/minimum-score-of-a-path-between-two-cities/
 *
 * @author lvrui
 */
public class MinScore {
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<String, Integer> weights = new HashMap<>();
        for (int[] road : roads) {
            List<Integer> integers = map.get(road[0]);
            if (integers != null) {
                integers.add(road[1]);
            } else {
                List<Integer> t = new ArrayList<>();
                t.add(road[1]);
                map.put(road[0], t);
            }
            List<Integer> tt = map.get(road[1]);
            if (tt != null) {
                tt.add(road[0]);
            } else {
                List<Integer> t = new ArrayList<>();
                t.add(road[0]);
                map.put(road[1], t);
            }

            weights.put(String.format("%s_%s", road[0], road[1]), road[2]);
            weights.put(String.format("%s_%s", road[1], road[0]), road[2]);
        }
        Set<Integer> access = new HashSet<>();
        int dfs = dfs(1, access, weights, map);
        return access.contains(n) ? dfs : -1;
    }

    private int dfs(int i, Set<Integer> access, Map<String, Integer> weights, Map<Integer, List<Integer>> map) {
        if (!access.add(i)) {
            return Integer.MAX_VALUE;
        }
        List<Integer> n = map.get(i);
        if (n == null) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;

        for (Integer next : n) {
            System.out.println(weights.get(String.format("%s_%s", i, next)));
            min = Math.min(min, weights.get(String.format("%s_%s", i, next)));
            min = Math.min(min, dfs(next, access, weights, map));
        }

        return min;
    }
    public int minScore2(int n, int[][] roads) {
        UF uf = new UF(n + 1);
        for (int[] r : roads) {
            uf.connect(r[0], r[1]);
        }
        int out = Integer.MAX_VALUE;
        for (int[] r : roads) {
            if (uf.isConnected(1, r[0])) {
                out = Math.min(out, r[2]);
            }
        }
        return out;
    }

    class UF {

        private int[] root;

        public UF(int n) {
            this.root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        private int root(int i) {
            if (root[i] == i) {
                return i;
            } else {
                root[i] = root[root[i]];
                return root(root[i]);
            }
        }

        public void connect(int i, int j) {
            root[root(i)] = root(j);
        }

        public boolean isConnected(int i, int j) {
            return root(i) == root(j);
        }
    }
    public static void main(String[] args) {
        MinScore minScore = new MinScore();
        minScore.minScore(4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}});
    }
}
