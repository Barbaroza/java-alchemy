package com.pmb.code.datastructure.array;

import java.util.*;

/**
 * Insert Delete GetRandom O(1)
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * <p>
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * 示例 :
 * <p>
 * // 初始化一个空的集合。
 * RandomizedSet randomSet = new RandomizedSet();
 * <p>
 * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomSet.insert(1);
 * <p>
 * // 返回 false ，表示集合中不存在 2 。
 * randomSet.remove(2);
 * <p>
 * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomSet.insert(2);
 * <p>
 * // getRandom 应随机返回 1 或 2 。
 * randomSet.getRandom();
 * <p>
 * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomSet.remove(1);
 * <p>
 * // 2 已在集合中，所以返回 false 。
 * randomSet.insert(2);
 * <p>
 * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * randomSet.getRandom();
 *
 * @author lvrui
 */
public class RandomizedSet {
    private Map<Integer, Integer> indexMap;
    private List<Integer> arr;
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        indexMap = new HashMap();
        arr = new ArrayList();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }

        indexMap.put(val, arr.size());
        arr.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        Integer toMoveIndex = indexMap.remove(val);
        if (toMoveIndex == null) {
            return false;
        }

        int swap = arr.get(arr.size() - 1);
        if (swap != val) {
            arr.set(toMoveIndex, swap);
            indexMap.put(swap, toMoveIndex);

        }
        arr.remove(arr.size() - 1);


        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return arr.get(random.nextInt(arr.size()));
    }

    public static void main(String[] args) {
    }
}
