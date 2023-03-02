package com.pmb.code.dp;

/**
 * https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/?favorite=xb9nqhhg
 *
 * @author lvrui
 */
public class Fib {
    int mod = (int) (1e9 + 7);

    public int fib(int n) {
        int pre2pre = 0;
        int pre = 1;
        if (n == 0) {

            return pre2pre;

        }
        if (n == 1) {
            return pre;
        }

        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (pre + pre2pre) % mod;

            pre2pre = pre;
            pre = res;
        }


        return res;

    }
}
