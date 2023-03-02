package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

/**
 * https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
 */
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return contains(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean contains(TreeNode a, TreeNode b) {

        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }


        return contains(a.right, b.right) && contains(a.left, b.left);
    }
}
