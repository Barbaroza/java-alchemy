package com.pmb.code.datastructure.tree.dfs;

import com.pmb.code.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *
 * @author lvrui
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> nodeList = new ArrayList<>();
        if (root == null) {
            return nodeList;
        }
        LinkedList<Integer> currentPath = new LinkedList<>();
        int currentSum = 0;
        dfs(root, currentSum, sum, currentPath, nodeList);
        return nodeList;
    }

    private void dfs(TreeNode root, int currentSum, int sum, LinkedList<Integer> currentPath, List<List<Integer>> nodeList) {
        if (root == null) {
            return;
        }
        int tempSum = root.val + currentSum;
        currentPath.addLast(root.val);
        if (tempSum == sum) {
            if (root.right == null && root.left == null) {
                nodeList.add(new ArrayList<>(currentPath));
            }
        }
        dfs(root.left, tempSum, sum, currentPath, nodeList);
        dfs(root.right, tempSum, sum, currentPath, nodeList);
        currentPath.removeLast();
    }


    public static void main(String[] args) {
        //[1,-2,-3,1,3,-2,null,-1]
        //-1
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(-2);
        treeNode.right = new TreeNode(-3);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(-2);
        treeNode.right.left.left = new TreeNode(-1);
        PathSum pathSum = new PathSum();
        pathSum.pathSum(treeNode, -5);
    }
}
