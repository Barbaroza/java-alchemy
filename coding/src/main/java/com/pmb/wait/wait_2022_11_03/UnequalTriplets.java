package com.pmb.wait.wait_2022_11_03;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-320/problems/number-of-unequal-triplets-in-array/
 * 6241. 数组中不等三元组的数目 显示英文描述
 * 通过的用户数0
 * 尝试过的用户数0
 * 用户总通过次数0
 * 用户总提交次数0
 * 题目难度Easy
 * 给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目：
 * <p>
 * 0 <= i < j < k < nums.length
 * nums[i]、nums[j] 和 nums[k] 两两不同 。
 * 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。
 * 返回满足上述条件三元组的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,4,2,4,3]
 * 输出：3
 * 解释：下面列出的三元组均满足题目条件：
 * - (0, 2, 4) 因为 4 != 2 != 3
 * - (1, 2, 4) 因为 4 != 2 != 3
 * - (2, 3, 4) 因为 2 != 4 != 3
 * 共计 3 个三元组，返回 3 。
 * 注意 (2, 0, 4) 不是有效的三元组，因为 2 > 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：不存在满足条件的三元组，所以返回 0 。
 *
 * @author lvrui
 */
public class UnequalTriplets {
    private static String KEY = "%s_%s_%s";

    public int unequalTriplets(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Set<String> unique = new HashSet<>();
        int first = -1;
        int second = -1;
        for (int i = 0; i < nums.length; i++) {
            first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {

                second = nums[j];
                if (second == first) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] == first || nums[k] == second) {
                        continue;
                    }
                    unique.add(String.format(KEY, i, j, j));
                }
            }
        }

        return unique.size();
    }
    public int unequalTriplets2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[k] != nums[i]) res++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        UnequalTriplets unequalTriplets = new UnequalTriplets();
        unequalTriplets.unequalTriplets(new int[]

                {
                        4, 4, 2, 4, 3
                });


    }
}
