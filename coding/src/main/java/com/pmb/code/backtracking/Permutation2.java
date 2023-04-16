package com.pmb.code.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvrui
 */
public class Permutation2 {
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();

        List<String> ans = new ArrayList();

        dfs(0, chars.length, ans, chars);

        return ans.toArray(new String[ans.size()]);
    }

    private void dfs(int i, int l, List<String> ans, char[] chars) {
        if (l == 0) {
            ans.add(String.copyValueOf(chars));
            return;
        }

        for (int j = chars.length - l; j < chars.length; j++) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;

            dfs(i + 1, l - 1, ans, chars);
            chars[j] = chars[i];
            chars[i] = t;
        }
    }
}
