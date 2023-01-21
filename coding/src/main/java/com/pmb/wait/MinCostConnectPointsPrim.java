package com.pmb.wait;

import java.util.*;

/**
 * @author lvrui
 */
public class MinCostConnectPointsPrim {
    public int minCostConnectPoints(int[][] points) {

        Map<Integer, Map<Integer, Integer>> nbTableMap = new HashMap<>(points.length);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int weight = weight(points[i], points[j]);
                Map<Integer, Integer> map = new HashMap<>();
                Map<Integer, Integer> original = nbTableMap.putIfAbsent(i, map);
                if (original != null) {
                    map = original;
                }
                map.put(j, weight);

                Map<Integer, Integer> mapa = new HashMap<>();
                Map<Integer, Integer> originala = nbTableMap.putIfAbsent(j, mapa);
                if (originala != null) {
                    mapa = originala;
                }
                mapa.put(i, weight);
            }
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> {
            return e1.getValue() - e2.getValue();
        });
        int res = 0;
        visited.add(0);
        Map<Integer, Integer> integerIntegerMap = nbTableMap.get(0);
        minHeap.addAll(integerIntegerMap.entrySet());
        while (!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> poll = minHeap.poll();
            if (visited.add(poll.getKey())) {
                res += poll.getValue();
                minHeap.addAll(nbTableMap.get(poll.getKey()).entrySet());
            }
            if (points.length == visited.size()) {
                break;
            }
        }

        return res;
    }

    private Integer weight(int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }

    public static void main(String[] args) {
        MinCostConnectPointsPrim minCostConnectPoints = new MinCostConnectPointsPrim();
        int i = minCostConnectPoints.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}});
        int b = minCostConnectPoints.minCostConnectPoints(new int[][]{{3, 12}, {-2, 5}, {-4, 1}});
        int c = minCostConnectPoints.minCostConnectPoints(new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}});

    }
}