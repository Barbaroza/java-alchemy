package com.pmb.wait_2023_02_01;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-330/problems/count-distinct-numbers-on-board/
 *
 * @author lvrui
 */
public class DistinctIntegers {
    public int distinctIntegers(int n) {
        Set<Integer> unique = new HashSet<>();
        unique.add(n);
        func(n, n, unique);

        return unique.size();
    }

    private void func(int start, int n, Set<Integer> unique) {
        for (int i = 1; i <= start; i++) {
            if (start % i == 1 && unique.add(i)) {
                func(i, n, unique);
            }
        }
    }

    boolean[] f = new boolean[101];

    public int distinctIntegers2(int n) {
        f[n] = true;
        for (int i = n; i > 1; i--) {
            if (f[i]) gao(i);
        }
        int re = 0;
        for (int i = 1; i <= n; i++) {
            if (f[i]) re++;
        }
        return re;
    }

    void gao(int n) {
        for (int i = n - 1; i > 1; i--) if (n % i == 1) f[i] = true;
    }


    public static void main(String[] args) {
        DistinctIntegers distinctIntegers = new DistinctIntegers();
        distinctIntegers.distinctIntegers(5);
    }
}
