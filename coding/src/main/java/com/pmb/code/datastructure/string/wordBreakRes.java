package com.pmb.code.datastructure.string;

import java.util.*;

/**
 * 单词拆分 II
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
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> res = new ArrayList<>();
        Map<Integer, List<String>> temp = new HashMap<>();
        if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
            return new ArrayList<>();
        }
        Set<String> hash = new LinkedHashSet<>(wordDict);
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (hash.contains(sub)) {
                    if (i == 0) {
                        temp.put(j, new ArrayList<String>() {{
                            add(sub);
                        }});
                    } else {
                        if (temp.containsKey(i)) {
                            List<String> tep = new ArrayList<>();
                            temp.get(i).forEach(tempRes ->
                            {
                                tep.add(tempRes + " " + sub);
                            });
                            if (temp.containsKey(j)) {
                                temp.get(j).addAll(tep);
                            } else {

                                temp.put(j, tep);
                            }
                        }
                    }
                }
            }
        }

        return temp.get(s.length()) == null ? new ArrayList<>() : temp.get(s.length());
    }

    //TODO 动态规划 回溯
    public static List<String> wordBreak2(String s, List<String> wordDict) {
        int len = s.length();
        // 状态定义：以 s[i] 结尾的子字符串是否符合题意
        boolean[] dp = new boolean[len];

        // 预处理
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }

        // 动态规划问题一般都有起点，起点也相对好判断一些
        // dp[0] = wordSet.contains(s.charAt(0));
        for (int r = 0; r < len; r++) {
            if (wordSet.contains(s.substring(0, r + 1))) {
                dp[r] = true;
                continue;
            }
            for (int l = 0; l < r; l++) {
                // dp[l] 写在前面会更快一点，否则还要去切片，然后再放入 hash 表判重
                if (dp[l] && wordSet.contains(s.substring(l + 1, r + 1))) {
                    dp[r] = true;
                    // 这个 break 很重要，一旦得到 dp[r] = True ，循环不必再继续
                    break;
                }
            }
        }

        List<String> res = new ArrayList<>();
        if (dp[len - 1]) {
            LinkedList<String> queue = new LinkedList<>();
            dfs(s, len - 1, wordSet, res, queue, dp);
            return res;
        }

        return res;
    }

    private static void dfs(String s, int end, Set<String> wordSet, List<String> res, LinkedList<String> queue, boolean[] dp) {
        if (wordSet.contains(s.substring(0, end + 1))) {
            queue.addFirst(s.substring(0, end + 1));

            StringBuilder stringBuilder = new StringBuilder();
            for (String word : queue) {
                stringBuilder.append(word);
                stringBuilder.append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            res.add(stringBuilder.toString());

            queue.removeFirst();
        }

        for (int i = 0; i < end; i++) {

            if (dp[i]) {
                String suffix = s.substring(i + 1, end + 1);

                if (wordSet.contains(suffix)) {
                    queue.addFirst(suffix);
                    dfs(s, i, wordSet, res, queue, dp);
                    queue.removeFirst();
                }
            }

        }
    }


    private static void getRes(String s, int start, int end, List<List<String>> res, List<String> wordDict, List<String> temp) {

    }


    public static void main(String[] args) {
        wordBreak2("appleBasd", new ArrayList<String>() {{
            add("a");
            add("ba");
            add("aaa");
            add("apple");
            add("asd");
            add("Basd");
            add("Ba");
            add("aaaaaaaa");
            add("aaaaaaaaa");
            add("aaaaaaaaaa");
        }});

    }

}
