package com.pmb.wait;

import java.util.*;

/**
 * D
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * <p>
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * <p>
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * 示例 2：
 * <p>
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 *
 * @author lvrui
 */
public class NumBusesToDestination {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> station2Station = new HashMap<>();
        Map<Integer, Set<Integer>> station2Bus = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                Set<Integer> bus = new HashSet<>();
                Set<Integer> previous = station2Bus.putIfAbsent(routes[i][j], bus);
                if (previous != null) {
                    bus = previous;
                }
                bus.add(i);

                int src = routes[i][j];
                int dst;
                if (j < routes[i].length - 1) {
                    dst = routes[i][j + 1];
                } else {
                    dst = routes[i][0];
                }
                Set<Integer> nb = new HashSet<>();
                Set<Integer> nbPrevious = station2Station.putIfAbsent(src, nb);
                if (nbPrevious == null) {
                    nbPrevious = nb;
                }
                nbPrevious.add(dst);
            }
        }

        Set<Integer> paths = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        List<List<Integer>> pathRes = new ArrayList<>();
        patsDfs(paths, queue, station2Station, pathRes, source, target);


        return minBus(pathRes, station2Bus);
    }

    private int minBus(List<List<Integer>> pathRes, Map<Integer, Set<Integer>> station2Bus) {
        if (pathRes.size() == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;

        for (List<Integer> paths : pathRes) {
            LinkedList<Integer> buses = new LinkedList<>();
            buses.add(-1);
            if (paths.size() == 1) {
                min = 0;
                break;
            }
            min = Math.min(min, busCounter(paths, 0, 0, buses, station2Bus));

        }

        return min;
    }

    private int busCounter(List<Integer> paths, int stationIndex, int busIndex, LinkedList<Integer> buses, Map<Integer, Set<Integer>> station2Bus) {
        if (stationIndex == paths.size()) {
            return 0;
        }
        Integer station = paths.get(stationIndex);
        Set<Integer> busList = station2Bus.get(station);

        Integer cost = Integer.MAX_VALUE;
        for (Integer bus : busList) {
            boolean isSame = buses.get(busIndex).equals(bus);
            buses.addLast(bus);
            int suffix = Integer.MAX_VALUE;
            suffix = Math.min(suffix, busCounter(paths, stationIndex + 1, busIndex + 1, buses, station2Bus));
            if (!isSame) {
                suffix++;
            }
            cost = Math.min(suffix, cost);
            buses.removeLast();
        }
        return cost;
    }

    private void patsDfs(Set<Integer> paths, LinkedList<Integer> queue, Map<Integer, Set<Integer>> station2Station, List<List<Integer>> pathRes, int source, int target) {
        if (!paths.add(source)) {
            return;
        }
        queue.addLast(source);
        if (source == target) {
            pathRes.add(new ArrayList<>(queue));
        }

        Set<Integer> dstList = station2Station.get(source);
        for (Integer dst : dstList) {
            patsDfs(paths, queue, station2Station, pathRes, dst, target);
        }
        paths.remove(source);
        queue.removeLast();

    }

    public int numBusesToDestination2(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        int n = routes.length;
        boolean[][] edge = new boolean[n][n];
        Map<Integer, List<Integer>> rec = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = rec.getOrDefault(site, new ArrayList<Integer>());
                for (int j : list) {
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                rec.put(site, list);
            }
        }

        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        Queue<Integer> que = new LinkedList<Integer>();
        for (int bus : rec.getOrDefault(source, new ArrayList<Integer>())) {
            dis[bus] = 1;
            que.offer(bus);
        }
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y = 0; y < n; y++) {
                if (edge[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    que.offer(y);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int bus : rec.getOrDefault(target, new ArrayList<Integer>())) {
            if (dis[bus] != -1) {
                ret = Math.min(ret, dis[bus]);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;

    }

    public static void main(String[] args) {
        NumBusesToDestination numBusesToDestination = new NumBusesToDestination();
        int i = numBusesToDestination.numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}, {6, 9}}, 3, 3);
    }
}
