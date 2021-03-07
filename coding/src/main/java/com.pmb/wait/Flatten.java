package com.pmb.wait;

import com.pmb.code.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 * <p>
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 *
 * @author lvrui
 */
public class Flatten {
    public void flatten(TreeNode root) {

        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }


    public void preorderTraversal2(TreeNode root, List<TreeNode> list) {
        LinkedList<TreeNode> temp = new LinkedList<>();
        if (root != null) {
            temp.add(root);

            while (temp.size() > 0) {
                TreeNode treeNode = temp.peekFirst();
                list.add(treeNode);
                TreeNode left = treeNode.left;
                TreeNode right = treeNode.right;
                while (left != null) {
                    temp.addLast(left);
                    left = left.left;
                }
                if (right != null) {
                    temp.addLast(right);
                }
            }
        }
    }

}
