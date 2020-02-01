package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

/**
 * @author lvrui
 */
public class lowestCommonAncestor2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = null;
        if (q.val > p.val) {
            res = dfs(root, p.val, q.val);
        } else {
            res = dfs(root, q.val, p.val);
        }
        return res;
    }

    private TreeNode dfs(TreeNode current, int val, int val1) {
        if (current == null) {
            return null;
        }
        if (val > current.val) {
            return dfs(current.right, val, val1);
        }
        if (current.val > val1) {
            return dfs(current.left, val, val1);
        }
        return current;
    }
}
