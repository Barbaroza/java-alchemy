package com.pmb.code.dp;

/**
 * @author lvrui
 */
public class NumWays {
    final int mod = (int) (1e9 + 7);

    public int numWays(int n) {
        int pre = 2;
        int pre2pre = 1;

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return pre2pre;
        }

        if (n == 2) {
            return pre;
        }

        int ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = (pre2pre + pre) % mod;
            pre2pre = pre;
            pre = ans;
        }

        return ans;

    }
}
