package com.pmb.wait;

import java.util.Objects;
import java.util.Stack;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 *
 * @author Administrator
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        return listTree(root, stack);
    }

    private Integer listTree(TreeNode root, Stack<TreeNode> stack) {
        Integer max = 0;
        if (!Objects.isNull(root)) {
            stack.push(root);
        } else {
            return stack.size();
        }
        max = stack.size() > max ? stack.size() : max;
        if (!Objects.isNull(root.left)) {
            int maxtemp = listTree(root.left, stack);
            max = max > maxtemp ? max : maxtemp;

        }
        if (!Objects.isNull(root.right)) {
            int maxtemp = listTree(root.right, stack);
            max = max > maxtemp ? max : maxtemp;
        }
        stack.pop();
        return max;
    }


    public class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;


        TreeNode(int x) {
            val = x;
        }

    }
}
