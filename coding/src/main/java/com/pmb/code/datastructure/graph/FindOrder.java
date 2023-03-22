package com.pmb.code.datastructure.graph;

import java.util.*;

/**
 * @author lvrui
 */
public class FindOrder {
    Map<Integer, Set<Integer>> graph = new HashMap();
    PriorityQueue<Map.Entry<Integer, Set<Integer>>> queue = new PriorityQueue<>((a, b) -> {
        int aSize = a.getValue().size();
        int bSize = b.getValue().size();
        return aSize == bSize ? a.getKey() - b.getKey() : aSize - bSize;
    });

    public int[] findOrder(int numCourses, int[][] prerequisites) {


        for (int i = 0; i < prerequisites.length; i++) {
            Set<Integer> t = graph.getOrDefault(prerequisites[i][0], new HashSet());
            t.add(prerequisites[i][1]);
            graph.put(prerequisites[i][0], t);
        }
        for (int i = 0; i < numCourses; i++) {
            Set<Integer> integers = graph.get(i);
            if (integers == null) {
                graph.put(i, new HashSet<>());
            }
        }

        int[] ans = new int[graph.size()];
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 0) {
                queue.add(entry);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                Map.Entry<Integer, Set<Integer>> e = queue.poll();

                ans[i++] = e.getKey();
                graph.remove(e.getKey());

                for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
                    entry.getValue().remove(e.getKey());
                }
            }
            for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
                if (entry.getValue().size() == 0) {
                    queue.add(entry);
                }
            }

        }

        return i != numCourses ? new int[]{} : ans;

    }



    public static void main(String[] args) {

        int[][] a = new int[2][];
        a[1] = new int[]{1, 0};
        a[0] = new int[]{0, 1};
        FindOrder findOrder = new FindOrder();
        findOrder.findOrder(2, a);
    }
}
