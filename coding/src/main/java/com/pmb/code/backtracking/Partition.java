package com.pmb.code.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lvrui
 */
public class Partition {

    boolean[][] dp;

    public String[][] partition(String s) {
        List<String[]> arr = new ArrayList<>();
        LinkedList<String> path = new LinkedList();
        dp = new boolean[s.length()][s.length()];
        build(s);

        dfs(0, s, arr, path);


        return arr.toArray(new String[arr.size()][]);
    }

    private void build(String s) {
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = s.length() - 1; i >= 0; --i) {
            for (int j = i + 1; j < s.length(); ++j) {
                if (j == i + 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {

                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }
            }
        }


    }


    private void dfs(int start, String s, List<String[]> ans, LinkedList<String> path) {

        if (start == s.length()) {
            ans.add(path.toArray(new String[path.size()]));
            return;
        }

        for (int i = start; i <= s.length() - 1; i++) {
            if (valid(start, i, s)) {
                path.addLast(s.substring(start, i + 1));
                dfs(i + 1, s, ans, path);
                path.removeLast();
            }
        }


    }

    private boolean valid(int start, int i, String s) {

        return dp[start][i];
    }

    public static void main(String[] args) {
        Partition p = new Partition();
        p.partition("bb");
    }
}
