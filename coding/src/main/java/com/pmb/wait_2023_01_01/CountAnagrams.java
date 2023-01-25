package com.pmb.wait_2023_01_01;

/**
 * https://leetcode.cn/contest/biweekly-contest-94/problems/count-anagrams/
 *
 * @author lvrui
 */
public class CountAnagrams {

    static long mod = 10_0000_0007l;

    static int size = 10_0000;


    static boolean ok = false;
    static long[] fac;
    static long[] infac;

    static long inv(long b) {
        long base = b % mod;
        long v = mod - 2;
        long res = 1l;

        while (v > 0) {
            if ((v & 0x01) == 1) {
                res = res * base % mod;
            }
            base = base * base % mod;
            v /= 2;
        }
        return res;
    }

    static void init() {
        if (ok) return;
        fac = new long[size + 1];
        infac = new long[size + 1];

        fac[0] = infac[0] = 1;

        for (int i = 1; i <= size; i++) {
            fac[i] = fac[i - 1] * i % mod;
            infac[i] = infac[i - 1] * inv(i) % mod;
        }

        ok = true;
    }

    static long query(int n, int k) {

        return fac[n] * infac[k] % mod * infac[n - k] % mod;

    }


    long compute(String w) {

        if (w.length() == 0) return 1;

        char[] buf = w.toCharArray();

        int[] tabs = new int[26];
        for (char c : buf) {
            tabs[c - 'a']++;
        }

        // 排列的计算
        int n = buf.length;

        long res = 1l;
        for (int i = 0; i < 26; i++) {
            if (tabs[i] > 0) {
                res = res * query(n, tabs[i]) % mod;
                n -= tabs[i];
            }
        }

        return res;
    }

    // *)
    public int countAnagrams(String s) {

        init();

        String[] ws = s.split("\\s+");

        long res = 1l;

        for (String w: ws) {
            long r = compute(w);
            res = res * r % mod;
        }

        return (int)res;

    }
}
