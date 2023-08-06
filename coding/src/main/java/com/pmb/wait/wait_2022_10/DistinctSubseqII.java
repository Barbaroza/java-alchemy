package com.pmb.wait.wait_2022_10;

import java.util.*;

/**
 * ##########
 * https://leetcode.cn/problems/distinct-subsequences-ii/
 * 940. 不同的子序列 II
 * 给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。
 * <p>
 * 字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc"
 * 输出：7
 * 解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
 * 示例 2：
 * <p>
 * 输入：s = "aba"
 * 输出：6
 * 解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
 * 示例 3：
 * <p>
 * 输入：s = "aaa"
 * 输出：3
 * 解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 *
 * @author lvrui
 */
public class DistinctSubseqII {

    private static final Integer MOD = 1000000009;


    //DP
    public int distinctSubseqII(String s) {

        Set<String> uk = new HashSet<>();
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        List<List<String>> temp = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int cnt = 0;
            String charCur = String.valueOf(s.charAt(i));
            List<String> cur = new ArrayList<>();


            for (List<String> pre : temp) {
                for (String preStr : pre) {
                    String s1 = preStr + charCur;
                    if (uk.add(s1)) {

                        cnt++;
                        cur.add(s1);
                    }
                }
            }

            if (uk.add(charCur)) {

                cnt++;
                cur.add(charCur);
            }
            temp.add(cur);

            dp[i + 1] = cnt;


        }


        return Arrays.stream(dp).reduce(0, (sum, i) -> sum += i);
    }


    public int distinctSubseqII2(String s) {

        Set<String> uk = new HashSet<>();
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String charCur = String.valueOf(s.charAt(i));

            int size = temp.size();

            for (int a = 0; a < size; a++) {
                String s1 = temp.get(a) + charCur;
                if (uk.add(s1)) {
                    temp.add(s1);
                }

            }

            if (uk.add(charCur)) {

                temp.add(charCur);
            }


        }


        return temp.size();
    }


    public static void main(String[] args) {
        DistinctSubseqII drCaller = new DistinctSubseqII();
        int aaaa = drCaller.distinctSubseqII2("abc");
        int baaaa = drCaller.distinctSubseqII2("aba");
        int cccc = drCaller.distinctSubseqII2("aaaa");
    }
}
