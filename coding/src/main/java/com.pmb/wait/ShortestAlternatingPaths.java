package com.pmb.wait;

import java.util.*;

/**
 * @undo
     * 1129. 颜色交替的最短路径
 * 在一个有向图中，节点分别标记为 0, 1, ..., n-1。这个图中的每条边不是红色就是蓝色，且存在自环或平行边。
 * <p>
 * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
 * <p>
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * 输出：[0,1,-1]
 * 示例 2：
 * <p>
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * 输出：[0,1,-1]
 * 示例 3：
 * <p>
 * 输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * 输出：[0,-1,-1]
 * 示例 4：
 * <p>
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * 输出：[0,1,2]
 * 示例 5：
 * <p>
 * 输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * 输出：[0,1,1]
 *
 * @author lvrui
 */
public class ShortestAlternatingPaths {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer, List<Integer>> blueMap = new HashMap<>();

        convertToMap(blue_edges, blueMap);
        convertToMap(red_edges, redMap);
        int[] res = new int[n + 1];
        Set<Integer> attachNode = new HashSet<>();
        dfsMinPath(1, 0, redMap, blueMap, attachNode, 1, res);
        attachNode.clear();
        dfsMinPath(-1, 0, blueMap, redMap, attachNode, 1, res);
        for (int index = 0; index < n + 1; index++) {
            if (res[index] == 0) {
                res[index] = -1;
            }
            if (index == 0) {
                res[index] = 0;
            }
        }
        int[] real = new int[n];
        System.arraycopy(res, 0, real, 0, n);
        return real;
    }

    private void dfsMinPath(int key, int i, Map<Integer, List<Integer>> firstMap, Map<Integer, List<Integer>> secondMap, Set<Integer> attachNode, int offset, int[] res) {
        boolean flag = true;
        for (int minPath : res) {
            if (offset < minPath || minPath == 0) {
                flag = false;
            }
        }
        if (flag) {
            return;
        }
        List<Integer> nodes = firstMap.get(i);
        if (nodes != null) {
            for (Integer node : nodes) {
                int currentKey = (node + 1) * key;
                if (attachNode.add(currentKey)) {
                    res[node] = res[node] == 0 ? offset : Math.min(res[node], offset);
                    dfsMinPath(-key, node, secondMap, firstMap, attachNode, offset + 1, res);
                    attachNode.remove(currentKey);
                }
            }
        }
    }


    private void convertToMap(int[][] edges, Map<Integer, List<Integer>> map) {
        for (int[] relation : edges) {
            List<Integer> neighbour = new ArrayList<>();
            List<Integer> defaultNeighbour = map.putIfAbsent(relation[0], neighbour);
            if (defaultNeighbour == null) {
                defaultNeighbour = neighbour;
            }
            defaultNeighbour.add(relation[1]);
        }
    }

    public int[] shortestAlternatingPaths2(int n, int[][] red_edges, int[][] blue_edges) {
        List<List<Integer>> rg = new ArrayList<>();//这是 红色线的集合
        List<List<Integer>> bg = new ArrayList<>();//这是 蓝色线的集合

        for (int i = 0; i < n; i++) {
            //初始化两条线的集合
            rg.add(new ArrayList<>());
            bg.add(new ArrayList<>());
        }

        //根据数组改变 红蓝色线 集合
        for (int[] red : red_edges)rg.get(red[0]).add(red[1]);
        for (int[] blue : blue_edges)bg.get(blue[0]).add(blue[1]);

        int[][] ans = new int[n][2];
        for (int[] ansColor : ans) {
            //初始化所有距离为MAX
            ansColor[0] = Integer.MAX_VALUE;
            ansColor[1] = Integer.MAX_VALUE;
        }
        //出发点距离设为0
        ans[0][0] = 0;
        ans[0][1] = 0;

        dfs(ans, 0, 0, rg, bg);//从红色线出发
        dfs(ans, 1, 0, rg, bg);//从蓝色线出发

        int[] finalAns = new int[n];
        for (int i = 0; i < n; i++) {
            //取最小值  没有的话为-1
            finalAns[i] = Math.min(ans[i][0], ans[i][1]);
            if (finalAns[i] == Integer.MAX_VALUE)
                finalAns[i] = -1;
        }
        return finalAns;
    }

    public void dfs(int[][] ans, int color, int i, List<List<Integer>> rg, List<List<Integer>> bg) {
        List<List<Integer>> g = color == 0 ? rg : bg;//选择 红蓝色 线
        for (int j : g.get(i)) {
            //遍历该线段 以 i 为出发点的终点

            if (ans[i][color] + 1 < ans[j][Math.abs(color - 1)]) {
                //判断 0 -> i -> j 的长度是否 比 已有的 0 -> j 的路径长度长 若是 则更新
                //!!!这个判断是整个算法的核心
                //当在也找不到更短的路径时 dfs会停止搜索 否则继续

                ans[j][Math.abs(color - 1)] = ans[i][color] + 1;
                dfs(ans, Math.abs(color - 1), j, rg, bg);
            }
        }
    }


    /**
     * [[0,1],[1,2],[2,3],[3,4]]
     * [[1,2],[2,3],[3,1]]
     *
     * @param args
     */
    public static void main(String[] args) {
        ShortestAlternatingPaths shortestAlternatingPaths = new ShortestAlternatingPaths();
        shortestAlternatingPaths.shortestAlternatingPaths(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, new int[][]{{1, 2}, {2, 3}, {3, 1}});
    }
}
