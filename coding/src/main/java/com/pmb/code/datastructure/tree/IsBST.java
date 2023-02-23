package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvrui
 */
public class IsBST {

    Map<TreeNode, Integer> hMap = new HashMap<>();

    public boolean isBST(TreeNode root) {
        return isBST(root.left) && isBST(root.right) && Math.abs(getH(root.left) - getH(root.right)) <= 1 && validateNode(root);
    }

    private boolean validateNode(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.right != null && root.right.val <= root.val) {
            return false;
        }

        if (root.left != null && root.val <= root.left.val) {
            return false;
        }

        return true;
    }

    private int getH(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Integer height = hMap.get(node);
        if (height == null) {
            height = Math.max(getH(node.right), getH(node.left)) + 1;
            hMap.put(node, height);
        }
        return height;
    }
}
