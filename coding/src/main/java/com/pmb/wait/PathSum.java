package com.pmb.wait;

import com.pmb.code.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * <p>
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 10000
 *
 * @author lvrui
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int path) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> tempStack = new LinkedList<>();
        if (root == null) {
            return res;
        }

        dfs(root, res, tempStack, path);


        return res;

    }

    private void dfs(TreeNode node, List<List<Integer>> res, Deque<Integer> tempStack, int tempSum) {
        if (node != null) {
            tempSum -= node.val;
            tempStack.addLast(node.val);

            if (tempSum == 0 && node.right == null && node.left == null) {
                res.add(new ArrayList<>(tempStack));
            }

            dfs(node.left, res, tempStack, tempSum);

            dfs(node.right, res, tempStack, tempSum);

            tempStack.pollLast();

        }
    }
}
