package com.pmb.code.datastructure.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * @author lvrui
 * @star
 */
public class NumSquares {

    public int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        Queue<Integer> path = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        path.add(n);
        visited.add(n);
        int layer = 0;
        while (!path.isEmpty()) {
            int size = path.size();
            layer++;
            for (int count = 0; count < size; count++) {
                Integer pop = path.poll();
                if (pop == 0) {
                    return layer;
                }
                for (int i = sqrt; i > 0; i--) {
                    int next = pop - i * i;
                    if (next >= 0 && !visited.contains(next)) {
                        visited.add(next);
                        path.add(next);

                    }
                }
            }
        }
        return layer;
    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        numSquares.numSquares(12);
    }

    /**
     * dp
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
