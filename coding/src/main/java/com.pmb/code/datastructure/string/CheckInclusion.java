package com.pmb.code.datastructure.string;

import java.util.*;

/**
 * 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * <p>
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * @author lvrui
 */
public class CheckInclusion {
    /**
     * 暴力 + 滑窗  超时
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        boolean res = false;
        if (s1 == null || s2 == null || s2.length() < s1.length()) {
            return res;
        }
        Set<String> allGroupStr = new HashSet<>();
        List<StringBuilder> all = getAll(s1);
        all.forEach(sb -> allGroupStr.add(sb.toString()));
        for (int index = 0; index + s1.length() <= s2.length(); index++) {
            if (allGroupStr.contains(s2.substring(index, index + s1.length()))) {
                res = true;
                break;
            }
        }
        return res;
    }

    public List<StringBuilder> getAll(String s1) {
        List<StringBuilder> res = new ArrayList<>();
        List<StringBuilder> temp = null;
        if (s1.length() > 1) {
            temp = getAll(s1.substring(1, s1.length()));
        }
        String current = s1.substring(0, 1);
        if (temp != null && temp.size() > 0) {
            for (StringBuilder str : temp) {
                for (int index = 0; index <= str.length(); index++) {
                    res.add(new StringBuilder(str).insert(index, current));
                }
            }
        } else {
            res.add(new StringBuilder(current));
        }

        return res;
    }


    /**
     * 概率统计+滑窗
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion2(String s1, String s2) {
        boolean res = false;
        if (s1 == null || s2 == null || s2.length() < s1.length()) {
            return res;
        }
        Map<String, Integer> all = getMap(s1);
        Map<String, Integer> temp = new HashMap<>();
        for (int index = 0; index + s1.length() <= s2.length(); index++) {
            if (index == 0) {
                temp = getMap(s2.substring(index, index + s1.length()));
            } else {
                String pre = s2.substring(index - 1, index);
                Integer integer = temp.get(pre);
                integer--;
                if (integer > 0) {
                    temp.put(pre, integer);
                } else {
                    temp.remove(pre);
                }
                String suffix = s2.substring(index + s1.length() - 1, index + s1.length());
                Integer suffixCount = temp.putIfAbsent(suffix, 1);
                if (suffixCount != null) {
                    temp.put(suffix, suffixCount + 1);
                }
            }
            res = true;
            for (Map.Entry<String, Integer> entry : all.entrySet()) {
                if (!entry.getValue().equals(temp.get(entry.getKey()))) {
                    res = false;
                    break;
                }
            }
            if (res) {
                break;

            }
        }
        return res;
    }

    private Map<String, Integer> getMap(String s1) {
        Map<String, Integer> all = new HashMap<>(s1.length());
        for (int index = 0; index < s1.length(); index++) {
            String substring = s1.substring(index, index + 1);
            Integer integer = all.putIfAbsent(substring, 1);
            if (integer != null) {
                all.put(substring, integer + 1);
            }
        }
        return all;
    }

    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        checkInclusion.checkInclusion2("ab", "eidbaooo");
    }
}
