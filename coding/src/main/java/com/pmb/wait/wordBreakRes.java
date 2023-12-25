package com.pmb.wait;

import org.python.google.common.base.Joiner;

import java.util.*;

/**
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 */

public class wordBreakRes {
    //@WAIT-V
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();

        if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
            return res;
        }
        Set<String> unique = new HashSet<>(wordDict);
        int min = wordDict.stream().mapToInt(String::length).min().getAsInt();
        int max = wordDict.stream().mapToInt(String::length).max().getAsInt();

        LinkedList<String> path = new LinkedList<>();

        dfs(0, min, max, path, unique, s, res);


        return res;
    }

    private void dfs(int start, int min, int max, LinkedList<String> path, Set<String> unique, String s, List<String> res) {
        if (start == s.length() && !path.isEmpty()) {
            res.add(Joiner.on(" ").join(path));
            return;
        }
        for (int i = min; i <= max && start + i <= s.length(); i++) {
            String sub = s.substring(start, start + i);
            if (unique.contains(sub)) {
                path.addLast(sub);
                dfs(start + i + 1, min, max, path, unique, s, res);
                path.removeLast();
            }
        }
    }
}
