package com.pmb.wait_2022_01_04.k_way_merge;

import java.util.*;

/**
 * @author lvrui
 * https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 * 373. 查找和最小的 K 对数字
 * 给定两个以 升序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * <p>
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 * <p>
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 * <p>
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums1.length, nums2.length <= 105
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1 和 nums2 均为升序排列
 * 1 <= k <= 1000
 * 通过次数33,542提交次数81,444
 */
public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2) -> {
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i, 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ans.add(list);
            if (idxPair[1] + 1 < n) {
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }

        return ans;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> (nums1[x[0]] + nums2[x[1]])));
        for (int i = 0; i < Math.min(nums1.length, k); i++) pq.offer(new int[]{i, 0});
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxs = pq.poll();
            ans.add(Arrays.asList(nums1[idxs[0]], nums2[idxs[1]]));
            if (idxs[1] + 1 < nums2.length) pq.offer(new int[]{idxs[0], idxs[1] + 1});
        }
        return ans;
    }
    /**
     * [[1,1],[1,1],[1,2],[1,3],[2,3]]
     * 预期结果：
     * [[1,1],[1,1],[2,1],[1,2],[1,2],[2,2],[1,3],[1,3],[2,3]]
     *
     * @param args
     */
    public static void main(String[] args) {
        KSmallestPairs kSmallestPairs = new KSmallestPairs();
        List<List<Integer>> lists = kSmallestPairs.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10);
    }
}
