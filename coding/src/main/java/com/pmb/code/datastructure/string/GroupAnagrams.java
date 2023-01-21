package com.pmb.code.datastructure.string;

import java.util.*;

/**
 * 字谜分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * <p>
 * ]
 *
 * @author lvrui
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> data = new HashMap<>();
        for (String str : strs) {
            if (str == null) {
                continue;
            }
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            for (char temp : chars) {
                sb.append(temp);
            }
            String key = sb.toString();
            List<String> strings = data.get(key);
            if (strings != null) {
                strings.add(str);
            } else {
                strings = new ArrayList<>();
                strings.add(str);
                data.put(key, strings);
            }
        }

        data.forEach((k, v) -> {
            res.add(v);
        });
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[]{""});
    }
}
