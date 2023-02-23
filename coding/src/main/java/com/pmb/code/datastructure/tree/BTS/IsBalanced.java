package com.pmb.code.datastructure.tree.BTS;

import com.pmb.code.model.TreeNode;

/**
 * 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 *
 * @author lvrui
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root != null) {
            int hRight = getHeight(root.right);
            int hLeft = getHeight(root.left);

            return Math.abs(hLeft - hRight) <= 1
                    && isBalanced(root.right)
                    && isBalanced(root.left);
        }

        return true;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(root.right), getHeight(root.left));
        }
    }

    public boolean isBalanced2(TreeNode root) {

        return root == null || isBalanced(root.right) && isBalanced(root.left) && Math.abs(dfs(root.left) - dfs(root.right)) <= 1;

    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(dfs(node.right) + 1, dfs(node.left) + 1);
    }
    public boolean isBalanced3(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


}
