package com.pmb.wait_2022_12_02;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/contest/biweekly-contest-93/problems/maximum-star-sum-of-a-graph/
 * @author lvrui
 */
public class MaxStarSum {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            map.put(i, new Node(vals[i]));
        }
        for (int[] edge : edges) {
            map.get(edge[0]).nbs.add(map.get(edge[1]).val);
            map.get(edge[1]).nbs.add(map.get(edge[0]).val);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < vals.length; i++) {

            Node node = map.get(i);
            int tem = node.val;
            int cnt = k;
            while (!node.nbs.isEmpty() && cnt > 0 && node.nbs.peek() > 0) {
                tem += node.nbs.poll();
                cnt--;
            }
            max = Math.max(max, tem);

        }
        return max;
    }

    public static class Node {
        int val;
        PriorityQueue<Integer> nbs = new PriorityQueue<>((a, b) -> -a.compareTo(b));

        public Node(int val) {
            this.val = val;
        }
    }


}
