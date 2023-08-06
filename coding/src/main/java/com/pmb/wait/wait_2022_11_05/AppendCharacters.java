package com.pmb.wait.wait_2022_11_05;

/**
 * https://leetcode.cn/contest/weekly-contest-321/problems/append-characters-to-string-to-make-subsequence/
 *
 * @author lvrui
 */
public class AppendCharacters {

    public int appendCharacters(String s, String t) {
        char[] cs = s.toCharArray();
        char[] subCs = t.toCharArray();
        int n = cs.length;
        int m = 0;

        for (int i = 0; i < n; i++) {
            if (cs[i] == subCs[m]) {
                m++;
                if (m == subCs.length) {
                    break;
                }
            }
        }

        return subCs.length - m;
    }

    public static void main(String[] args) {
        AppendCharacters appendCharacters = new AppendCharacters();
        appendCharacters.appendCharacters("aa", "a");
    }
}
