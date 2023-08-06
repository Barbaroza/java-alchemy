package com.pmb.wait.wait_2022_10;

import java.util.*;

/**
 * #####
 * https://leetcode.cn/problems/online-stock-span/
 * <p>
 * 901. 股票价格跨度
 * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
 * <p>
 * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 * <p>
 * 实现 StockSpanner 类：
 * <p>
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * 输出：
 * [null, 1, 1, 1, 2, 1, 4, 6]
 * <p>
 * 解释：
 * StockSpanner stockSpanner = new StockSpanner();
 * stockSpanner.next(100); // 返回 1
 * stockSpanner.next(80);  // 返回 1
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(70);  // 返回 2
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(75);  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
 * stockSpanner.next(85);  // 返回 6
 * <p>
 * 提示：
 * <p>
 * 1 <= price <= 105
 * 最多调用 next 方法 104 次
 */
public class StockSpanner {

    private List<Integer> nums;

    private Map<Integer, Integer> index2Cnt;

    private Integer index;


    public StockSpanner() {
        nums = new ArrayList<>();
        index2Cnt = new HashMap<>();
        index = 0;

    }

    public int next(int price) {
        int res = 0;
        if (index != 0) {

            Integer prePrice = nums.get(index - 1);

            if (prePrice <= price) {
                int currentPrice = findBiggerThan(nums, index2Cnt, price, index - 1) + 1;
                index2Cnt.put(index, currentPrice);
                res = currentPrice;
            } else {
                index2Cnt.put(index, 1);
                res = 1;
            }

        } else {
            index2Cnt.put(index, 1);
            res = 1;
        }

        nums.add(price);

        index++;

        return res;

    }

    private int findBiggerThan(List<Integer> nums, Map<Integer, Integer> index2Cnt, int price, Integer index) {
        if (index < 0) {
            return 0;
        }


        Integer num = nums.get(index);

        if (num > price) {
            return 0;
        } else {
            Integer duration = index2Cnt.get(index);
            return duration + findBiggerThan(nums, index2Cnt, price, index - duration);
        }


    }

    public static class StockSpanner2 {
        Stack<Integer> prices, weights;

        public StockSpanner2() {
            prices = new Stack();
            weights = new Stack();
        }

        public int next2(int price) {
            int w = 1;
            while (!prices.isEmpty() && prices.peek() <= price) {
                prices.pop();
                w += weights.pop();
            }

            prices.push(price);
            weights.push(w);
            return w;
        }




    }

    public static class StockSpanner3 {
        Deque<int[]> stack;
        int idx;

        public StockSpanner3() {
            stack = new ArrayDeque<int[]>();
            stack.push(new int[]{-1, Integer.MAX_VALUE});
            idx = -1;
        }

        public int next3(int price) {
            idx++;
            while (price >= stack.peek()[1]) {
                stack.pop();
            }
            int ret = idx - stack.peek()[0];
            stack.push(new int[]{idx, price});
            return ret;
        }

    }


}

