package com.pmb.wait_2022_05;

import com.pmb.code.model.TreeNode;

/**
 * https://leetcode.cn/problems/univalued-binary-tree/
 * @author lvrui
 */
public class IsUnivalTree {
    public boolean isUnivalTree(TreeNode root) {

        if (root == null) {
            return true;
        }
        if (!(isUnivalTree(root.left) && (root.left == null || root.left.val == root.val))) {
            return false;
        }
        if (!(isUnivalTree(root.right) && (root.right == null || root.right.val == root.val))) {
            return false;
        }
        return true;
    }


    public boolean isUnivalTree2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (root.val != root.left.val || !isUnivalTree2(root.left)) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val != root.right.val || !isUnivalTree2(root.right)) {
                return false;
            }
        }
        return true;
    }


}
