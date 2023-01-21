package com.pmb.wait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvrui
 * @overtime
 * 787. K 站中转内最便宜的航班
 * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 * <p>
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * 示例 2：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n 范围是 [1, 100]，城市标签从 0 到 n - 1
 * 航班数量范围是 [0, n * (n - 1) / 2]
 * 每个航班的格式 (src, dst, price)
 * 每个航班的价格范围是 [1, 10000]
 * k 范围是 [0, n - 1]
 * 航班没有重复，且不存在自环
 */
public class FindCheapestPrice {
    private static final String KEY_FORMAT = "%s—%s";

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (n < K + 1) {
            return 0;
        }
        Map<String, Integer> costMap = new HashMap<>();
        Map<Integer, List<Integer>> neighbourMap = new HashMap<>();
        for (int[] path : flights) {
            List<Integer> defaultPath = new ArrayList<>();
            List<Integer> current = neighbourMap.putIfAbsent(path[0], defaultPath);
            if (current != null) {
                defaultPath = current;
            }
            defaultPath.add(path[1]);
            costMap.put(String.format(KEY_FORMAT, path[0], path[1]), path[2]);
        }


        int res = Integer.MAX_VALUE;
        res = dfs(src, dst, costMap, neighbourMap, K, Integer.MAX_VALUE);


        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(int src, int dst, Map<String, Integer> costMap, Map<Integer, List<Integer>> neighbourMap, int k, int res) {
        if (k < 0) {
            return Integer.MAX_VALUE;
        }
        List<Integer> integers = neighbourMap.get(src);
        int temp = Integer.MAX_VALUE;
        boolean flag = true;
        if (integers != null) {
            for (Integer currentDst : integers) {
                Integer cost = costMap.get(String.format(KEY_FORMAT, src, currentDst));
                if (currentDst == dst) {
                    temp = Math.min(res == Integer.MAX_VALUE ? cost : res + cost, temp);
                } else {

                    temp = Math.min(dfs(currentDst, dst, costMap, neighbourMap, k - 1, res == Integer.MAX_VALUE ? cost : res + cost), temp);
                }
            }
        }
        return temp;
    }


    /**
     * 3
     * [[0,1,100],[1,2,100],[0,2,500]]
     * 0
     * 2
     * 1
     * <p>
     * <p>
     * 3
     * [[0,1,100],[1,2,100],[0,2,500]]
     * 0
     * 2
     * 0
     *
     * @param args 3
     *             [[0,1,2],[1,2,1],[2,0,10]]
     *             1
     *             2
     *             1
     *             <p>
     *             <p>
     *             <p>
     *             3
     *             [[0,1,100],[1,2,100],[0,2,500]]
     *             0
     *             2
     *             1
     */
    public static void main(String[] args) {
        FindCheapestPrice findCheapestPrice = new FindCheapestPrice();
        int cheapestPrice = findCheapestPrice.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1);
        cheapestPrice = 0;
    }
}
