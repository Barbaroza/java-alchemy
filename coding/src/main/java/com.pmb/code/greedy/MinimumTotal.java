package com.pmb.code.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * @author lvrui
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;
        if (triangle == null || triangle.isEmpty()) {
            return res;
        }
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int index = 1; index < triangle.size(); index++) {
            List<Integer> integers = triangle.get(index);
            int[] temp = Arrays.copyOf(dp, dp.length);
            for (int i = 0; i < integers.size(); i++) {
                if (i == 0) {
                    temp[i] = dp[0] + integers.get(i);
                } else if (i == integers.size() - 1) {
                    temp[i] = dp[i - 1] + integers.get(i);
                } else {
                    temp[i] = Math.min(dp[i - 1], dp[i]) + integers.get(i);
                }
            }
            dp = temp;
        }

        for (int path : dp) {
            res = res < path ? res : path;
        }

        return res;
    }

    /**
     * 自底向上, DP 【AC】
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minlen = new int[row+1];
        for (int level = row-1;level>=0;level--){
            for (int i = 0;i<=level;i++){   //第i行有i+1个数字
                minlen[i] = Math.min(minlen[i], minlen[i+1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];
    }

    public static void main(String[] args) {
        MinimumTotal minimumTotal = new MinimumTotal();
        minimumTotal.minimumTotal(new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>() {{
                add(2);
            }});
            add(new ArrayList<Integer>() {{
                add(3);
                add(4);
            }});
            add(new ArrayList<Integer>() {{
                add(6);
                add(5);
                add(7);
            }});
            add(new ArrayList<Integer>() {{
                add(4);
                add(1);
                add(8);
                add(3);
            }});
        }});
    }
}
