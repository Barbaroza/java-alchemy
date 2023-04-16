package com.pmb.code.backtracking;

import java.util.*;

/**
 * https://leetcode.cn/problems/permutation-ii-lcci/submissions/
 *
 * @author lvrui
 */
public class Permutation3 {
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        List<String> ans = new ArrayList<>();

        dfs(0, ans, chars);

        return ans.toArray(new String[ans.size()]);
    }

    private void dfs(int i, List<String> ans, char[] chars) {
        if (i == chars.length) {
            ans.add(new String(chars));
            return;
        }

        for (int k = i; k < chars.length; k++) {
            Arrays.sort(chars, i, chars.length);

            if (k > i && chars[k] == chars[k - 1]) {
                continue;
            }
            swap(i, k, chars);

            dfs(i + 1, ans, chars);
            swap(i, k, chars);


        }
    }


    private void swap(int i, int j, char[] chars) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public String[] permutation2(String S) {
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        List<String> ans = new ArrayList<>();
        bt(0, ans, chars);

        return ans.toArray(new String[ans.size()]);
    }

    private void bt(int i, List<String> ans, char[] chars) {
        if (i == chars.length) {
            ans.add(new String(chars));
            return;
        }
        Set<Character> unique = new HashSet<>();
        for (int l = i; l < chars.length; l++) {
            if (unique.add(chars[l])) {
                swap(i, l, chars);
                bt(i + 1, ans, chars);
                swap(i, l, chars);
            }
        }
    }
}
