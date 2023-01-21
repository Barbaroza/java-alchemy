package com.pmb.wait_2022_11_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-320/problems/minimum-fuel-cost-to-report-to-the-capital/
 * 6243. 到达首都的最少油耗 显示英文描述
 * 通过的用户数283
 * 尝试过的用户数380
 * 用户总通过次数284
 * 用户总提交次数492
 * 题目难度Medium
 * 给你一棵 n 个节点的树（一个无向、连通、无环图），每个节点表示一个城市，编号从 0 到 n - 1 ，且恰好有 n - 1 条路。0 是首都。给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] ，表示城市 ai 和 bi 之间有一条 双向路 。
 * <p>
 * 每个城市里有一个代表，他们都要去首都参加一个会议。
 * <p>
 * 每座城市里有一辆车。给你一个整数 seats 表示每辆车里面座位的数目。
 * <p>
 * 城市里的代表可以选择乘坐所在城市的车，或者乘坐其他城市的车。相邻城市之间一辆车的油耗是一升汽油。
 * <p>
 * 请你返回到达首都最少需要多少升汽油。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：roads = [[0,1],[0,2],[0,3]], seats = 5
 * 输出：3
 * 解释：
 * - 代表 1 直接到达首都，消耗 1 升汽油。
 * - 代表 2 直接到达首都，消耗 1 升汽油。
 * - 代表 3 直接到达首都，消耗 1 升汽油。
 * 最少消耗 3 升汽油。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2
 * 输出：7
 * 解释：
 * - 代表 2 到达城市 3 ，消耗 1 升汽油。
 * - 代表 2 和代表 3 一起到达城市 1 ，消耗 1 升汽油。
 * - 代表 2 和代表 3 一起到达首都，消耗 1 升汽油。
 * - 代表 1 直接到达首都，消耗 1 升汽油。
 * - 代表 5 直接到达首都，消耗 1 升汽油。
 * - 代表 6 到达城市 4 ，消耗 1 升汽油。
 * - 代表 4 和代表 6 一起到达首都，消耗 1 升汽油。
 * 最少消耗 7 升汽油。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：roads = [], seats = 1
 * 输出：0
 * 解释：没有代表需要从别的城市到达首都。
 *
 * @author lvrui
 */
public class MinimumFuelCost {
    long count;

    public long minimumFuelCost(int[][] roads, int seats) {
        HashMap<Integer, List<Integer>> listHashMap = new HashMap<>();
        int n = roads.length + 1;
        for (int i = 0; i < n; i++) {
            listHashMap.put(i, new ArrayList<>());
        }
        for (int[] road : roads) {
            int left = road[0];
            int right = road[1];
            listHashMap.get(left).add(right);
            listHashMap.get(right).add(left);
        }
        count = 0;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(listHashMap, 0, seats, visited);
        return count;
    }

    public long dfs(HashMap<Integer, List<Integer>> listHashMap, int index, int seats, boolean[] visited) {
        long res = 1;
        List<Integer> list = listHashMap.get(index);
        for (Integer integer : list) {
            if (!visited[integer]) {
                visited[integer] = true;
                long dfs = dfs(listHashMap, integer, seats, visited);
                count += (dfs + seats - 1) / seats;
                res += dfs;
            }
        }
        return res;
    }
}
