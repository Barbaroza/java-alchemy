package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/6eUYwP/submissions/
 *
 * @author lvrui
 */
public class PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }

    Map<Long, Integer> prefixCnt = new HashMap<>();

    public int pathSum2(TreeNode root, int targetSum) {
        prefixCnt.put(0L, 1);

        return preOrder(root, 0, targetSum);
    }

    private int preOrder(TreeNode root, long preValue, int targetSum) {
        if (root == null) {
            return 0;
        }
        preValue += root.val;

        int res = 0;

        res += prefixCnt.getOrDefault(preValue - targetSum, 0);

        prefixCnt.put(preValue, prefixCnt.getOrDefault(preValue, 0) + 1);
        res += preOrder(root.left, preValue, targetSum);
        res += preOrder(root.right, preValue, targetSum);
        prefixCnt.put(preValue, prefixCnt.getOrDefault(preValue, 0) - 1);

        return res;
    }
}
