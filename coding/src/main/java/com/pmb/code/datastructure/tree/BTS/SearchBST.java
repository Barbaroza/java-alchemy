package com.pmb.code.datastructure.tree.BTS;

import com.pmb.code.model.TreeNode;

/**
 * Search in a Binary Search Tree
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * <p>
 * 例如，
 * <p>
 * 给定二叉搜索树:
 * <p>
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * 和值: 2
 * 你应该返回如下子树:
 * <p>
 * 2
 * / \
 * 1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 *
 * @author lvrui
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode current = root;
        while (current != null) {
            if (val == current.val) {
                break;
            }
            if (val < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }


        return current;
    }
}
