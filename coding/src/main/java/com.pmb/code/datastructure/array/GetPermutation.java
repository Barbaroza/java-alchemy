package com.pmb.code.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * @star
 *
 * @author lvrui
 */
public class GetPermutation {

    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];
        // 将 n! 种排列分为：n 组，每组有 (n - 1)! 种排列
        return recursive(n, factorial(n - 1), k, visited);
    }

    /**
     * 求 n!
     */
    private int factorial(int n) {
        int res = 1;
        for (int i = n; i > 1; i--) {
            res *= i;
        }
        return res;
    }

    /**
     * @param n 剩余的数字个数，递减
     * @param f 每组的排列个数
     */
    private String recursive(int n, int f, int k, boolean[] visited) {
        int offset = k % f;// 组内偏移量
        int groupIndex = k / f + (offset > 0 ? 1 : 0);// 第几组
        // 在没有被访问的数字里找第 groupIndex 个数字
        int i = 0;
        for (; i < visited.length && groupIndex > 0; i++) {
            if (!visited[i]) {
                groupIndex--;
            }
        }
        visited[i - 1] = true;// 标记为已访问
        if (n - 1 > 0) {
            // offset = 0 时，则取第 i 组的第 f 个排列，否则取第 i 组的第 offset 个排列
            return String.valueOf(i) + recursive(n - 1, f / (n - 1), offset == 0 ? f : offset, visited);
        } else {
            // 最后一数字
            return String.valueOf(i);
        }
    }


    public static void main(String[] args) {
        GetPermutation getPermutation = new GetPermutation();
        getPermutation.getPermutation(3, 2);
    }
}
