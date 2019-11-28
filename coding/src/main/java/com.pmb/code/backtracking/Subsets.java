package com.pmb.code.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 * @author lvrui
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = null;
        if (nums != null && nums.length > 0) {
            Arrays.sort(nums);
            res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                for (int n = i; n < nums.length; n++) {
                    List<Integer> temp = new ArrayList<>();
                    for (int start = i; start <= n; start++) {
                        temp.add(nums[start]);
                    }
                    res.add(temp);
                }
            }
            res.add(new ArrayList<>());
        }
        return res;

    }

    public static void main(String[] args) {
        Subsets sb = new Subsets();
        sb.subsets(new int[]{1, 2, 3});
    }
}
