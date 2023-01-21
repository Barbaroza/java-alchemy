package com.pmb.code.datastructure.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 * @author lvrui
 * @star
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, List<Integer>> map1 = new HashMap<>(s.length());
        Map<Character, List<Integer>> map2 = new HashMap<>(s.length());
        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            char cc = t.charAt(index);
            List<Integer> integers = map1.get(c);
            if (integers == null) {
                integers = new ArrayList<Integer>();
                map1.put(c, integers);
            }
            integers.add(index);
            List<Integer> integers2 = map2.get(cc);
            if (integers2 == null) {
                integers2 = new ArrayList<Integer>();
                map2.put(cc, integers2);
            }
            integers2.add(index);
            if (!integers.equals(integers2)) {
                return false;
            }
        }
        return true;
    }
    public boolean isIsomorphic2(String s, String t) {
        return isIsomorphicHelper(s).equals(isIsomorphicHelper(t));
    }

    private String isIsomorphicHelper(String s) {
        int[] map = new int[128];
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //当前字母第一次出现,赋值
            if (map[c] == 0) {
                map[c] = count;
                count++;
            }
            sb.append(map[c]);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        IsIsomorphic isIsomorphic = new IsIsomorphic();
        isIsomorphic.isIsomorphic("add", "egg");
    }
}
