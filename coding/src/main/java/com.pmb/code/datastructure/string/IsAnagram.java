package com.pmb.code.datastructure.string;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author lvrui
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null  || t == null ) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] arrS = new int[26];
        int[] arrT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            arrS[charS - 'a']++;
            char charT = t.charAt(i);
            arrT[charT - 'a']++;
        }
        for (int i = 0; i < arrS.length; i++) {
            if (arrS[i] != arrT[i]) {
                return false;
            }
        }
        return true;
    }
}
