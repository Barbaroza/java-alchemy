package com.pmb.code.datastructure.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * @author lvrui
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return false;
        }
        Map<Integer, List<Integer>> indexMap = new HashMap<Integer, List<Integer>>();

        for (int index = 0; index < nums.length; index++) {
            List<Integer> array = indexMap.get(nums[index]);
            if (array == null) {
                array = new ArrayList<Integer>();
                indexMap.put(nums[index], array);
            }
            array.add(index);
        }
        for (Map.Entry<Integer, List<Integer>> entry : indexMap.entrySet()) {
            List<Integer> array = entry.getValue();
            if (array.size() > 1) {
                for (int i = 0; i < array.size(); i++) {
                    for (int j = i + 1; j < array.size(); j++) {
                        if ((array.get(j) - array.get(i) == k)) {

                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate containsNearbyDuplicate = new ContainsNearbyDuplicate();
        containsNearbyDuplicate.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 3);
    }
}
