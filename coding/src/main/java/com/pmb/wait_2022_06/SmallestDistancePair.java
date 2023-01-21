package com.pmb.wait_2022_06;

import java.util.LinkedList;

/**
 * @author lvrui
 * @wait https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 * 719. 找出第 K 小的数对距离
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,1], k = 1
 * 输出：0
 * 解释：数对和对应的距离如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 距离第 1 小的数对是 (1,1) ，距离为 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1,6,1], k = 3
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 2 <= n <= 104
 * 0 <= nums[i] <= 106
 * 1 <= k <= n * (n - 1) / 2
 */
public class SmallestDistancePair {

    LinkedList<Integer> res = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();


    public int smallestDistancePair(int[] nums, int k) {

//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>() {
//            @Override
//            public Comparator<? super Integer> comparator() {
//                return (Comparator<Integer>) Comparator.comparingInt((Integer o) -> o);
//            }
//        };


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int abs = Math.abs(nums[j] - nums[i]);
                if (res.size() != 0) {
                    while (res.size() != 0 && res.getLast() > abs) {
                        temp.addLast(res.removeLast());
                    }
                    if (res.size() < k) {
                        res.addLast(abs);
                    }
                    while (temp.size() != 0 && res.size() < k) {
                        res.addLast(temp.removeLast());
                    }
                    temp.clear();
                } else {
                    res.push(abs);
                }
            }
        }



        return res.getLast();
    }


    public static void main(String[] args) {
        SmallestDistancePair smallestDistancePair = new SmallestDistancePair();
        smallestDistancePair.smallestDistancePair(new int[]{2,2,0,1,1,0,0,1,2,0}, 2);    }
}
