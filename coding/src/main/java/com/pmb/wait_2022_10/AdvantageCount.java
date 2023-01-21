package com.pmb.wait_2022_10;

import java.util.Arrays;

/**
 * #########
 * https://leetcode.cn/problems/advantage-shuffle/
 * 870. 优势洗牌
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 * <p>
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 * <p>
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length <= 105
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 109
 *
 * @author lvrui
 */
public class AdvantageCount {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; ++i) {
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);

        int[] ans = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; ++i) {
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                ans[idx2[left]] = nums1[idx1[i]];
                ++left;
            } else {
                ans[idx2[right]] = nums1[idx1[i]];
                --right;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        AdvantageCount advantageCount = new AdvantageCount();
        advantageCount.advantageCount(new int[]{1,7,11,15}, new int[]{1,9,11,15});
    }
}
