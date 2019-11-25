package com.pmb.code2.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        int start = 0;
        boolean flag = false;
        for (int i = start; i < s.length(); i++) {
            flag = fun(start, i + 1, s, wordDict);
            if (flag) {
                break;
            }
        }
        return flag;

    }

    private static boolean fun(int start, int end, String s, List<String> wordDict) {
        if (end > s.length()) {
            return false;
        }
        String temp = s.substring(start, end);
        boolean flag = wordDict.contains(temp);

        if (flag && end == (s.length())) {
            return true;
        } else {
            if (flag) {
                return fun(end, end + 1, s, wordDict);
            } else {
                return fun(start, end + 1, s, wordDict);
            }
        }
    }

    public static void main(String[] args) {
        WordBreak.wordBreak("aaaaaaa", new ArrayList<String>() {{
            add("aaaa");
            add("aaa");
        }});
    }

}
