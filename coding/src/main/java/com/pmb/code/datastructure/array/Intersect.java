package com.pmb.code.datastructure.array;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author lvrui
 */
public class Intersect {

    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] res;
        if (nums1.length > nums2.length) {
            res = calc(nums1, nums2);
        } else {
            res = calc(nums2, nums1);
        }
        return res;
    }

    private static int[] calc(int[] nums1, int[] nums2) {
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>(nums2.length);
        List<Integer> resList = new ArrayList<Integer>(nums2.length);
        for (int entity : nums2) {
            if (tempMap.containsKey(entity)) {
                tempMap.put(entity, tempMap.get(entity) + 1);
            } else {
                tempMap.put(entity, 1);
            }
        }
        for (int entity : nums1) {
            Integer count = tempMap.get(entity);
            if (count != null && count > 0) {
                resList.add(entity);
                count--;
                tempMap.put(entity, count);
            }
        }

        int[] result = new int[resList.size()];

        for (int k = 0; k < resList.size(); k++) {
            result[k] = resList.get(k);
        }
        return result;
    }
    public static int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        if (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                j++;
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            }
        }

        int[] result = new int[list.size()];

        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] res = Intersect.intersect(new int[]{2, 2}, new int[]{1, 2, 2, 1});
        res = null;
    }
}
