package com.pmb.code.datastructure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author lvrui
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = null;
        if (nums == null || nums.length == 0) {
            return res;
        }
        res = new int[2];
        outer:
        for (int index = 0; index < nums.length; index++) {
            for (int innerIndex = index + 1; innerIndex < nums.length; innerIndex++) {
                if (nums[index] + nums[innerIndex] == target) {
                    res[0] = index;
                    res[1] = innerIndex;
                    break outer;
                }
            }
        }
        return res;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] res = null;
        if (nums == null || nums.length == 0) {
            return res;
        }
        res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            map.put(nums[index], index);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (target - entry.getKey() != entry.getKey()) {
                Integer integer = map.get(target - entry.getKey());
                if (integer != null) {
                    res[0] = entry.getValue();
                    res[1] = integer;
                    break;

                }
            }
        }

        return res;
    }
}
