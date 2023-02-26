package com.pmb.code.datastructure.tree.traversal;

import com.pmb.code.model.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/NYBBNL/
 *
 * @author lvrui
 */
public class IncreasingBST {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode vNode = new TreeNode(Integer.MIN_VALUE);


        TreeNode ans = vNode;
        TreeNode cur = root;
        LinkedList<TreeNode> deque = new LinkedList();
        while (!deque.isEmpty() || cur != null) {
            while (cur != null) {
                deque.addFirst(cur);
                cur = cur.left;
            }


            TreeNode pop = deque.removeFirst();

            ans.right = pop;
            ans.left = null;
            ans = pop;

            cur = pop.right;


        }
        ans.left = null;


        return vNode.right;
    }


    public static void main(String[] args) {
        TreeNode r = new TreeNode(2);
        TreeNode rl = new TreeNode(1);
        TreeNode rr = new TreeNode(4);
        TreeNode rrl = new TreeNode(3);
        r.left = rl;
        r.right = rr;
        rr.left = rrl;

        IncreasingBST i = new IncreasingBST();
        TreeNode treeNode = i.increasingBST(r);
    }
}
