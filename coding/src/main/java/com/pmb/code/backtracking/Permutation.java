package com.pmb.code.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * @author lvrui
 */
public class Permutation {

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }


        List<String> ans = new ArrayList<>();
        StringBuilder appender = new StringBuilder();

        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[chars.length];
        Arrays.sort(chars);

        dfs(chars, appender, ans, visited);


        return ans.toArray(new String[ans.size()]);
    }

    private void dfs(char[] chars, StringBuilder appender, List<String> ans, boolean[] visited) {
        if (appender.length() == chars.length) {
            ans.add(appender.toString());
            return;
        }


        for (int i = 0; i < chars.length; i++) {
            if ((i > 0 && chars[i] == chars[i - 1]) || visited[i]) {
                continue;
            }
            visited[i] = true;
            appender.append(chars[i]);

            dfs(chars, appender, ans, visited);

            visited[i] = false;
            appender.deleteCharAt(appender.length() - 1);

        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.permutation("aab");
    }
}
