package com.pmb.wait_2022_06;

import java.util.*;

/**
 * @author lvrui
 * @wait https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 * 532. 数组中的 k-diff 数对
 * 给定一个整数数组和一个整数 k，你需要在数组里找到 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 * <p>
 * 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 * <p>
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * 示例 2：
 * <p>
 * 输入：nums = [1, 2, 3, 4, 5], k = 1
 * 输出：4
 * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * 示例 3：
 * <p>
 * 输入：nums = [1, 3, 1, 5, 4], k = 0
 * 输出：1
 * 解释：数组中只有一个 0-diff 数对，(1, 1)。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 */
public class FindPairs {
    public int findPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> arr = new ArrayList<>();
            List<Integer> integers = indexMap.putIfAbsent(nums[i], arr);
            if (integers == null) {
                integers = arr;
            }
            integers.add(i);
        }

        int cnt = 0;
        Set<Integer> access = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int a = k + nums[i];
            int min = Math.min(a, nums[i]);
            List<Integer> integers = indexMap.get(a);
            if (access.add(min) && integers != null && integers.get(integers.size() - 1) > i) {
                cnt++;
            }

            a = -k + nums[i];
            min = Math.min(a, nums[i]);
            integers = indexMap.get(a);
            if (access.add(min) && integers != null && integers.get(integers.size() - 1) > i) {

                cnt++;
            }
        }

        return cnt;
    }

    public int findPairs2(int[] nums, int k) {
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }




    public static void main(String[] args) {
        FindPairs f = new FindPairs();
        int pairs = f.findPairs(new int[]{1, 2, 3, 4, 5}, 1);
    }
}
