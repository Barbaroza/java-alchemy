package com.pmb.code.datastructure.tree.BTS;

import com.pmb.code.model.TreeNode;

import java.util.Stack;

/**
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @author lvrui
 */
public class IsValidBST {


    public boolean isValidBST(TreeNode root) {

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        Integer min = Integer.MIN_VALUE;
        boolean first = true;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode pop = stack.pop();
            if (first) {
                min = pop.val;
                first = false;
            } else {
                if (min < pop.val) {
                    min = pop.val;
                } else {
                    return false;
                }
            }
            current = pop.right;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);

        IsValidBST isValidBST = new IsValidBST();
        isValidBST.isValidBST(treeNode);

    }

}
