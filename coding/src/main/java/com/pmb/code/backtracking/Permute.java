package com.pmb.code.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/VvJkup/solution/mei-you-zhong-fu-yuan-su-ji-he-de-quan-p-5blh/
 * 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @author lvrui
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i]))
                    continue;
                temp.add(nums[i]);
                backtrack(list, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        permute.permute(new int[]{1, 2, 3});
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList();
        if(nums == null){
            return ans;
        }
        boolean[] visit = new boolean[nums.length];
        backTracing(nums,visit,ans,path);

        return ans;
    }


    private void backTracing(int[] nums,boolean[] visit,List<List<Integer>>ans,LinkedList<Integer> path){
        if(path.size() == nums.length){
            ans.add(new ArrayList(path));
            return;
        }


        for(int i =0;i<nums.length;i++){
            if(visit[i]){
                continue;
            }
            visit[i] =true;
            path.addLast(nums[i]);
            backTracing(nums,visit,ans,path);
            path.removeLast();

            visit[i] =false;
        }
    }


}
