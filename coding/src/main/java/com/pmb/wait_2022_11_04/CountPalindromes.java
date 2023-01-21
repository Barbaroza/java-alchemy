package com.pmb.wait_2022_11_04;

/**
 * https://leetcode.cn/contest/biweekly-contest-92/problems/count-palindromic-subsequences/
 *
 * @author lvrui
 */
public class CountPalindromes {
    int mod = 100000007;

    public int countPalindromes(String S) {
        final int mod = 1000000007;
        char[] s = S.toCharArray();
        int n = s.length;
        long ans = 0;
        int[] ff = new int[10];
        for (int i = 0; i < n; i++) {
            long m = 0;
            for (int j = n - 1; j > i; j--) {
                if (s[i] == s[j]) {
                    ans += m * (j - i - 1);
//						ans %= mod;
                }
                m += ff[s[j] - '0'];
                if (m >= mod) m -= mod;
            }
            ff[s[i] - '0']++;
        }
        return (int) (ans % mod);
    }

    public int countPalindromes2(String s) {
        int n = s.length();
        int[] cc = new int[10];
        for (int i = 0; i < n; i++) {
            cc[s.charAt(i) - 48]++;
        }
        int[] cc2 = new int[10];
        long[][] dc = new long[n][100];
        cc2[s.charAt(n - 1) - 48] = 1;
        for (int i = n - 2; i >= 0; i--) {
            int cur = s.charAt(i) - 48;
            for (int j = 0; j < 100; j++) {
                dc[i][j] = dc[i + 1][j];
            }
            for (int j = 0; j <= 9; j++) {
                dc[i][cur * 10 + j] += cc2[j];
            }
            cc2[cur]++;
        }

        int[] cc3 = new int[10];
        long[] dc2 = new long[100];
        cc3[s.charAt(0) - 48]++;
        long ret = 0L;
        long mod = 1000000007;
        for (int i = 1; i < n - 2; i++) {
            for (int j = 0; j < 100; j++) {
                int t = (j % 10) * 10 + (j / 10);
                ret = ret + (dc2[j] * dc[i + 1][t]);
                ret %= mod;
            }
            int cur = s.charAt(i) - 48;
            for (int j = 0; j < 10; j++) {
                dc2[j * 10 + cur] += cc3[j];
            }
            cc3[cur]++;
        }
        return (int) ret;
    }
}
