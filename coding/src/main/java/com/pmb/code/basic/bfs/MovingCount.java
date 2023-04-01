package com.pmb.code.basic.bfs;

import com.pmb.code.basic.prefix.Solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 *
 * @author lvrui
 */
public class MovingCount {
    public int movingCount(int m, int n, int k) {

        LinkedList<int[]> queue = new LinkedList<>();
        Set<String> access = new HashSet<>();
        queue.addLast(new int[]{0, 0});
        access.add(key(0, 0));

        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.removeFirst();
            cnt++;
            if (cur[0] < m - 1 && access.add(key(cur[0] + 1, cur[1])) && value(cur[0] + 1, cur[1]) <= k) {
                queue.addLast(new int[]{cur[0] + 1, cur[1]});
            }
            if (cur[1] < n - 1 && access.add(key(cur[0], cur[1] + 1)) && value(cur[0], cur[1] + 1) <= k) {
                queue.addLast(new int[]{cur[0], cur[1] + 1});
            }

        }

        return cnt;
    }

    private String key(int i, int j) {
        return String.format("%s-%s", i, j);
    }

    private int value(int i, int j) {
        int sum = 0;

        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }

        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        MovingCount m = new MovingCount();
        m.movingCount(
                16,
                8,
                4);

    }

    public int movingCount2(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] vis = new boolean[m][n];
        int ans = 1;
        vis[0][0] = true;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                    continue;
                }
                // 边界判断
                if (i - 1 >= 0) {
                    vis[i][j] |= vis[i - 1][j];
                }
                if (j - 1 >= 0) {
                    vis[i][j] |= vis[i][j - 1];
                }
                ans += vis[i][j] ? 1 : 0;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

}
