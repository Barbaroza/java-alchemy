package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * @author lvrui
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        List<TreeNode> pathQ = new ArrayList<>();
        List<TreeNode> pathP = new ArrayList<>();
        Stack<TreeNode> currentPath = new Stack<>();
        findPath(root, p.val, q.val, currentPath, pathP, pathQ);
        int minLength = Math.min(pathP.size(), pathQ.size());
        TreeNode res = null;
        for (int index = 0; index < minLength; index++) {
            TreeNode treeNode1 = pathP.get(index);
            TreeNode treeNode = pathQ.get(index);
            if (treeNode1.val == treeNode.val) {
                res = treeNode;
            } else {
                break;
            }
        }
        return res;
    }

    private void findPath(TreeNode root, int p, int q, Stack<TreeNode> currentPath, List<TreeNode> pathP, List<TreeNode> pathQ) {
        if (!pathP.isEmpty() && !pathQ.isEmpty()) {
            return;
        }
        if (root == null) {
            return;
        }
        currentPath.add(root);
        if (root.val == p) {
            pathP.addAll(currentPath);
        }
        if (root.val == q) {
            pathQ.addAll(currentPath);
        }
        findPath(root.right, p, q, currentPath, pathP, pathQ);
        findPath(root.left, p, q, currentPath, pathP, pathQ);
        currentPath.pop();
    }

    private TreeNode ans;

    public LowestCommonAncestor() {
        // Variable to store LCA node.
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }

}
