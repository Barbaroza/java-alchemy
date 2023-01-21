package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

/**
 * @author lvrui
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return has(root, sum, 0);
    }

    public boolean has(TreeNode node, int sum, int cur) {
        if (node == null) {
            return false;
        }
        int value = cur + node.val;
        if (node.left == null && node.right == null && value == sum) {
            return true;
        }
        return has(node.right, sum, value) || has(node.left, sum, value);
    }
}
