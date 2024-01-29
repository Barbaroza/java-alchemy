package com.pmb.wait;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 743.
 * 网络延迟时间
 * 有 n 个网络节点，标记为 1 到 n。
 * <p>
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边
 *
 * @wait-v
 * @author lvrui
 */
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, PriorityQueue<Path>> djs = new HashMap<>();

        for (int[] path : times) {
            Path p = new Path(path[0], path[1], path[2]);
            PriorityQueue<Path> paths = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
            PriorityQueue<Path> origin = djs.putIfAbsent(p.src, paths);
            if (origin == null) {
                origin = paths;
            }
            origin.add(p);
        }

        Set<Integer> visited = new HashSet<>();
        Deque<Integer> cPath = new LinkedList<>();
        int[] cnt = new int[3];
        cnt[0] = Integer.MAX_VALUE;
        cnt[2] = djs.keySet().size();
        dfs(djs, times[k][0], visited, cPath, cnt);

        return cnt[0] == Integer.MAX_VALUE ? -1 : cnt[0];

    }

    private void dfs(Map<Integer, PriorityQueue<Path>> djs, int src, Set<Integer> visited, Deque<Integer> cPath, int[] cnt) {
        if (visited.add(src)) {
            PriorityQueue<Path> paths = djs.get(src);
            if (paths == null) {
                return;
            }
            for (Path p : paths) {
                int fCost = cnt[1] + p.weight;
                if (fCost >= cnt[0]) {
                    continue;
                }
                cnt[1] += p.weight;

                dfs(djs, p.dst, visited, cPath, cnt);

                cnt[1] -= p.weight;

            }
            visited.remove(src);
        } else {
            if (visited.size() == cnt[2]) {
                if (cnt[1] < cnt[0]) {
                    cnt[0] = cnt[1];
                }
            }
        }
    }

    class Path {
        Integer src;
        Integer dst;
        Integer weight;

        public Path(Integer src, Integer dst, Integer weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }

    public int networkDelayTime2(int[][] cost, int n, int k) {
        Map<Integer, Map<Integer, Integer>> nb = Arrays.stream(cost).collect(Collectors.groupingBy(e -> e[0], Collectors.toMap(e -> e[1], e -> e[2], (k1, k2) -> k1)));
        Set<Integer> accessed = new HashSet<>();
        int max = dfs(accessed, k, nb);

        return accessed.size() != n ? -1 : max;
    }

    private int dfs(Set<Integer> accessed, int k, Map<Integer, Map<Integer, Integer>> nb) {

        int cost = 0;
        if (!accessed.add(k)) {
            return cost;
        }
        Map<Integer, Integer> orDefault = nb.getOrDefault(k, new HashMap<>());
        for (Map.Entry<Integer, Integer> edge : orDefault.entrySet()) {
            cost = Math.max(dfs(accessed, edge.getKey(), nb), cost) + edge.getValue();
        }
        return cost;
    }


    public static void main(String[] args) {
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int i = networkDelayTime.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2);
    }
}
