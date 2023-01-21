package com.pmb.code.datastructure;

import java.util.*;

/**
 * 全 O(1) 的数据结构
 * 实现一个数据结构支持以下操作：
 * <p>
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 * 挑战：以 O(1) 的时间复杂度实现所有操作。
 *
 * @author lvrui
 */
public class AllOne {
    TreeMap<Integer, Set<String>> treeMap = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });
    Map<String, Integer> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public AllOne() {

    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        Integer integer = map.putIfAbsent(key, 1);
        if (integer == null) {
            Set<String> strings = treeMap.get(1);
            if (strings == null) {
                treeMap.put(1, new HashSet<String>() {{
                    add(key);
                }});
            } else {
                strings.add(key);
            }
        } else {
            map.put(key, integer + 1);
            treeMap.get(integer).remove(key);
            if (treeMap.get(integer).isEmpty()) {
                treeMap.remove(integer);
            }
            Set<String> strings = treeMap.get(integer + 1);
            if (strings == null) {
                treeMap.put(integer + 1, new HashSet<String>() {{
                    add(key);
                }});
            } else {
                strings.add(key);
            }
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        Integer integer = map.get(key);
        if (integer != null) {
            if (integer == 1) {
                map.remove(key);
                treeMap.get(1).remove(key);
                if (treeMap.get(1).isEmpty()) {
                    treeMap.remove(1);
                }
            } else {
                map.put(key, integer - 1);
                treeMap.get(integer).remove(key);
                if (treeMap.get(integer).isEmpty()) {
                    treeMap.remove(integer);
                }
                Set<String> strings = treeMap.get(integer - 1);
                if (strings == null) {
                    treeMap.put(integer - 1, new HashSet<String>() {{
                        add(key);
                    }});
                } else {
                    strings.add(key);
                }
            }
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        Map.Entry<Integer, Set<String>> integerSetEntry = treeMap.lastEntry();
        if (integerSetEntry != null) {
            Set<String> value = integerSetEntry.getValue();
            if (!value.isEmpty()) {
                return value.iterator().next();
            }
        }
        return "";
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        Map.Entry<Integer, Set<String>> integerSetEntry = treeMap.firstEntry();
        if (integerSetEntry != null) {
            Set<String> value = integerSetEntry.getValue();
            if (!value.isEmpty()) {
                return value.iterator().next();
            }
        }
        return "";
    }
}
