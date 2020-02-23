package com.pmb.code.datastructure.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * @star
 * @author lvrui
 */
public class FrequencySort {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        if (s == null || s.isEmpty()) {
            return sb.toString();
        }

        Map<Character, Integer> countMap = new HashMap<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            Integer integer = countMap.putIfAbsent(c, 1);
            if (integer != null) {
                countMap.put(c, integer + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            queue.add(new Pair(entry.getKey(), entry.getValue()));
        }
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int temp = 0;

            while (temp < poll.count) {
                sb.append(poll.character);
                temp++;
            }
        }
//        for (Pair pair : queue) {
//            int temp = 0;
//
//            while (temp < pair.count) {
//                sb.append(pair.character);
//                temp++;
//            }
//        }
        return sb.toString();
    }


    class Pair implements Comparable<Pair> {
        Character character;
        Integer count;

        Pair(Character str, Integer count) {
            this.character = str;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            return o.count - count;
        }
    }

    public static void main(String[] args) {
        FrequencySort frequencySort = new FrequencySort();
        frequencySort.frequencySort("raaeaedere");
    }
}
