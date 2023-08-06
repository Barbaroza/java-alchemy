package com.pmb.code.basic.dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * https://leetcode.cn/problems/IY6buf/
 *
 * @author lvrui
 */
public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[n][m];
    }

    private Set<String> access = new HashSet<>();

    public boolean isInterleave2(String s1, String s2, String s3) {


        if ("".equals(s1) && "".equals(s2) && "".equals(s3)) {
            return true;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return dfs(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0);
    }

    private boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k) {
        if (k > c3.length || i > c1.length || j > c2.length) {
            return false;
        }
        if (k == c3.length && i == c1.length && j == c2.length) {
            return true;
        }
        if (!access.add("" + i + j + k)) {
            return false;
        }
        boolean ans = false;
        if (i < c1.length && c1[i] == c3[k]) {
            ans = dfs(c1, c2, c3, i + 1, j, k + 1);
        }

        if (j < c2.length && c2[j] == c3[k]) {
            ans = ans || dfs(c1, c2, c3, i, j + 1, k + 1);
        }

        return ans;
    }


    /**
     * "aabcc"
     * "dbbca"
     * "aadbbcbcac"
     *
     * @param args
     */
    public static void main(String[] args) {
        IsInterleave isInterleave = new IsInterleave();
        isInterleave.isInterleave2("aabcc", "dbbca", "aadbbcbcac");
    }

}
