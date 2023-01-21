package com.pmb.code.datastructure.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author lvrui
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> count = new HashSet<>(Math.max(nums1.length, nums2.length));
        Set<Integer> unique = new HashSet<>(nums1.length);
        int[] res = new int[Math.max(nums1.length, nums2.length)];
        for (int num : nums1) {
            unique.add(num);
        }
        int index = 0;
        for (int num : nums2) {
            if (unique.contains(num)) {
                if (count.add(num)) {
                    res[index++] = num;
                }
            }
        }
        String a = new String();
        return Arrays.copyOf(res, index);
    }
}
