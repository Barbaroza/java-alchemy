package com.pmb.code.datastructure.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author lvrui
 */
public class LongestWord {

    public String longestWord(String[] words) {
        // TreeMap<Integer, Set<String>> collect = Arrays.stream(words)
        // .collect(Collectors.groupingBy(e -> e.length(), () -> new TreeMap(), Collectors.toSet()));

        TreeMap<Integer, Set<String>> collect = new TreeMap<>();

        for (String sub : words) {
            int l = sub.length();
            Set<String> cur = collect.getOrDefault(l, new HashSet<>());
            cur.add(sub);

            collect.put(l, cur);
        }


        Arrays.sort(words, (o1, o2) -> {
            int c = o2.length() - o1.length();
            return c != 0 ? c : o1.compareTo(o2);
        });
        String ans = "";

        for (java.lang.String sub : words) {
            if (check(sub, 0, collect)) {
                ans = sub;
                break;
            }
        }

        return ans;
    }

    private boolean check(String str, int i, TreeMap<Integer, Set<String>> collect) {
        Integer min = collect.firstKey();
        Integer max = collect.lastKey();
        boolean ans = false;
        for (int j = i + min; j < str.length() + 1 && j < i + max + 1; j++) {
            String subStr = str.substring(i, j);
            Set<String> g = collect.get(j - i);
            if (g == null || !g.contains(subStr)) {
                continue;
            }
            if (i != 0 && j == str.length()) {
                return true;
            } else if (j < str.length()) {
                ans = check(str, j, collect);
            }
            if (ans) {
                break;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        LongestWord longestWord = new LongestWord();
        longestWord.longestWord(new String[]{"121", "12", "1", "222"});
    }
}
