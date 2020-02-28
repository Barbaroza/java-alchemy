package com.pmb.code.datastructure.hash;

import java.util.*;

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
        if (nums == null || nums.length <2|| k < 0) {
            return false;
        }
        Set<Integer> unique = new HashSet<Integer>();
        for(int i=0;i<k+1&&i<nums.length;i++)
        {
            if(!unique.add(nums[i]))
            {
                return true;
            }
        }
        for(int i=1,j=k+1;j<nums.length;i++,j++)
        {
            unique.remove(nums[i-1]);
            if(!unique.add(nums[j]))
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate containsNearbyDuplicate = new ContainsNearbyDuplicate();
        containsNearbyDuplicate.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 3);
    }
}
