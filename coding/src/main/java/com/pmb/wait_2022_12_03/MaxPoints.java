package com.pmb.wait_2022_12_03;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

/**
 * https://leetcode.cn/contest/weekly-contest-323/problems/maximum-number-of-points-from-grid-queries/
 *
 * @author lvrui
 */
public class MaxPoints {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            Set<String> access = new HashSet<>();

            ans[i] = score(0, 0, grid, queries[i], access);
        }

        return ans;
    }

    private String format = "%s_%s";

    private int score(int i, int j, int[][] grid, int query, Set<String> access) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        String key = String.format(format, i, j);
        if (!access.add(key)) {
            return 0;
        }
        if (grid[i][j] >= query) {
            return 0;
        }
        int temp = 1;

        temp += score(i + 1, j, grid, query, access);
        temp += score(i - 1, j, grid, query, access);
        temp += score(i, j + 1, grid, query, access);
        temp += score(i, j - 1, grid, query, access);

        return temp;
    }


    public int[] maxPoints2(int[][] g, int[] qs) {
        int row = g.length, col = g[0].length;
        int max = 0;
        for (int x : qs)
            max = Math.max(max, x);
        int s = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[2], y[2]));
        boolean[][] flag = new boolean[row][col];
        pq.add(new int[]{0, 0, g[0][0]});
        flag[0][0] = true;
        TreeMap<Integer, Integer> t = new TreeMap<>();
        t.put(0, 0);
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!pq.isEmpty()) {
            int cut = pq.peek()[2];
            while (!pq.isEmpty() && pq.peek()[2] <= cut) {
                int[] tup = pq.poll();
                int r = tup[0], c = tup[1], x = tup[2];
                s++;
                for (int[] d : dir) {
                    int tr = r + d[0], tc = c + d[1];
                    if (tr < 0 || tr >= row || tc < 0 || tc >= col || flag[tr][tc]) continue;
                    pq.add(new int[]{tr, tc, g[tr][tc]});
                    flag[tr][tc] = true;
                }
            }
            t.put(cut, s);
        }
        int n = qs.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int k = t.lowerKey(qs[i]);
            ans[i] = t.get(k);
        }
        return ans;
    }

//    truct UnionFind {
//        int n;
//        vector<int> parent, size;
//
//        UnionFind(int n) {
//            this->n = n;
//            parent = vector<int>(n);
//            size = vector<int>(n, 1);
//            for (int i = 0; i < n; ++i)
//                parent[i] = i;
//        }
//
//        int find(int idx) {
//            if (parent[idx] == idx)
//                return idx;
//            return parent[idx] = find(parent[idx]);
//        }
//
//        void connect(int a, int b) {
//            int fa = find(a), fb = find(b);
//            if (fa != fb) {
//                if (size[fa] > size[fb]) {
//                    parent[fb] = fa;
//                    size[fa] += size[fb];
//                } else {
//                    parent[fa] = fb;
//                    size[fb] += size[fa];
//                }
//            }
//        }
//
//        int components() {
//            vector<bool> is_root(n);
//            for (int i = 0; i < n; ++i)
//                is_root[find(i)] = true;
//            int ans = 0;
//            for (int i = 0; i < n; ++i)
//                ans += is_root[i];
//            return ans;
//        }
//    };
//
//    class Solution {
//        public:
//        vector<int> maxPoints(vector<vector<int>> &grid, vector<int> &queries) {
//            int n = grid.size(), m = grid[0].size();
//            int q = queries.size();
//            UnionFind uf(n * m);
//            vector<int> order(q);
//            iota(order.begin(), order.end(), 0);
//            sort(order.begin(), order.end(),
//                    [&](int a, int b) { return queries[a] < queries[b]; });
//
//            vector<tuple<int, int, int>> nums(n * m);
//            for (int i = 0; i < n; ++i)
//                for (int j = 0; j < m; ++j)
//                    nums[i * m + j] = make_tuple(grid[i][j], i, j);
//            sort(nums.begin(), nums.end());
//
//            int ptr = 0;
//            vector<int> ans(q);
//            for (int i : order) {
//                while (ptr + 1 < n * m && get<0>(nums[ptr + 1]) < queries[i]) {
//                    ptr++;
//                    auto [_, r, c] = nums[ptr];
//                    if (r > 0 && grid[r - 1][c] < queries[i])
//                        uf.connect(r * m + c, (r - 1) * m + c);
//                    if (r + 1 < n && grid[r + 1][c] < queries[i])
//                        uf.connect(r * m + c, (r + 1) * m + c);
//                    if (c > 0 && grid[r][c - 1] < queries[i])
//                        uf.connect(r * m + c, r * m + c - 1);
//                    if (c + 1 < m && grid[r][c + 1] < queries[i])
//                        uf.connect(r * m + c, r * m + c + 1);
//                }
//                if (grid[0][0] < queries[i])
//                    ans[i] = uf.size[uf.find(0)];
//            }
//
//            return ans;
//        }
//    };

}
