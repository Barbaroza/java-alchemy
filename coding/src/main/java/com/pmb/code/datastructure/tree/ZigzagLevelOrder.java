package com.pmb.code.datastructure.tree;


import com.pmb.code.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 * @author lvrui
 */
public class ZigzagLevelOrder {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean flag = true;
        Stack<TreeNode> queue = new Stack<>();
        queue.add(root);
        List<Integer> resList = new ArrayList<>();
        List<TreeNode> arr = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.pop();
            resList.add(poll.val);
            if (flag) {
                if (poll.left != null) {
                    arr.add(poll.left);
                }
                if (poll.right != null) {
                    arr.add(poll.right);
                }
            } else {
                if (poll.right != null) {
                    arr.add(poll.right);
                }
                if (poll.left != null) {
                    arr.add(poll.left);
                }
            }
            if (queue.isEmpty()) {
                flag = !flag;
                for (TreeNode node : arr) {
                    queue.add(node);
                }
                arr.clear();
                res.add(new ArrayList<>(resList));
                resList.clear();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        zigzagLevelOrder(treeNode);
    }
}
