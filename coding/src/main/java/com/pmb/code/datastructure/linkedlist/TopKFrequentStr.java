package com.pmb.code.datastructure.linkedlist;

import java.util.*;

/**
 * @author lvrui
 */
public class TopKFrequentStr {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int c = o2.getValue() - o1.getValue();
                if (c == 0) {
                    c = o2.getKey().compareTo(o1.getKey());
                }
                return c;
            }
        });
        Map<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            Integer orDefault = map.getOrDefault(word, 0);
            orDefault++;
            map.put(word, orDefault);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }
        while (k > 0) {
            res.add(pq.poll().getKey());
            k--;
        }

        return res;
    }
}
