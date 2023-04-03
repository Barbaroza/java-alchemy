package com.pmb.code.datastructure.tree.ancestor;

import com.pmb.code.model.TreeNode;

/**
 * https://leetcode.cn/problems/first-common-ancestor-lcci/submissions/
 * @author lvrui
 */
public class LowestCommonAncestor3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(p == root || q == root){
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);

        if(l!=null && r!=null){
            return root;
        }

        return l!=null ? l : r;
    }
}
