package com.pmb.code.datastructure.linkedlist;

import java.util.*;

/**
 * @author lvrui
 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> temp = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            } else {
                countMap.put(nums[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = countMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            temp.add(entry);
        }
        List<Integer> res = new ArrayList<Integer>(nums.length);
        for(int i =0;i<k;i++)
        {
            Map.Entry<Integer, Integer> head = temp.poll();
                res.add(head.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        List<Integer> res = topKFrequent.topKFrequent(new int[]{1,1,1,2,2,3}, 2);

        res = null;
    }
}
