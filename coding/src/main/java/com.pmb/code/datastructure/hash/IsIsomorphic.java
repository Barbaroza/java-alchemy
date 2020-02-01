package com.pmb.code.datastructure.hash;

import java.util.HashMap;
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
 * @star
 * @author lvrui
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>(s.length() * 2);
        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            char cc = t.charAt(index);
            Character character = map.putIfAbsent(c, cc);
            if (character != null && !character.equals(cc)) {
                return false;
            }
            Character character1 = map.get(cc);
            if (character1!=null && !character1.equals(c)) {
                return false;
            }


        }
        return true;
    }

    public static void main(String[] args) {
        IsIsomorphic isIsomorphic = new IsIsomorphic();
        isIsomorphic.isIsomorphic("ab", "ca");
    }
}
