package com.pmb.code.basic.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author lvrui
 */
public class FindWhetherExistsPath {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        LinkedList<Integer> queue = new LinkedList();

        Set<Integer>[] ad = new Set[n + 1];

        for (int[] g : graph) {
            ad[g[0]] = ad[g[0]] == null ? new HashSet<>() : ad[g[0]];
            ad[g[0]].add(g[1]);
        }
        Set<Integer> access = new HashSet<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int c = queue.removeFirst();
            if (!access.add(c)) {
                continue;
            }
            if (ad[c].contains(target)) {
                return true;
            }
            for (int nb : ad[c]) {
                queue.addLast(nb);
            }

        }


        return false;
    }

    public static void main(String[] args) {
        FindWhetherExistsPath findWhetherExistsPath = new FindWhetherExistsPath();
        findWhetherExistsPath.findWhetherExistsPath(12, new int[][]{{0, 1}, {1, 2}, {1, 3}, {1, 10}, {1, 11}, {1, 4}, {2, 4}, {2, 6}, {2, 9}, {2, 10}, {2, 4}, {2, 5}, {2, 10}, {3, 7}, {3, 7}, {4, 5}, {4, 11}, {4, 11}, {4, 10}, {5, 7}, {5, 10}, {6, 8}, {7, 11}, {8, 10}},
                2, 3);

    }
}
