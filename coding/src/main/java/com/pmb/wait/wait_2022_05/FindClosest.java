package com.pmb.wait.wait_2022_05;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-closest-lcci/
 * 面试题 17.11. 单词距离
 * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * 提示：
 * <p>
 * words.length <= 100000
 * 通过次数46,034提交次数62,875
 *
 * @author lvrui
 */
public class FindClosest {
    public int findClosest(String[] words, String word1, String word2) {
        List<Integer> index1 = new ArrayList<>();
        List<Integer> index2 = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1.add(i);
            } else if (words[i].equals(word2)) {
                index2.add(i);
            }

        }

        int res = Integer.MAX_VALUE;

        for (int i : index1) {
            for (int n : index2) {
                res = Math.min(Math.abs(i - n), res);
            }
        }
        return res ;

    }


    public int findClosest2(String[] ws, String a, String b) {
        int n = ws.length, ans = n;
        for (int i = 0, p = -1, q = -1; i < n; i++) {
            String t = ws[i];
            if (t.equals(a)) p = i;
            if (t.equals(b)) q = i;
            if (p != -1 && q != -1) ans = Math.min(ans, Math.abs(p - q));
        }
        return ans;
    }


    public int findClosest3(String[] words, String word1, String word2) {
        int length = words.length;
        int ans = length;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i;
            } else if (word.equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                ans = Math.min(ans, Math.abs(index1 - index2));
            }
        }
        return ans;
    }



}
