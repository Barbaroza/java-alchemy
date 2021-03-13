package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * @author lvrui
 */
public class Flatten {


    public TreeNode flatten(TreeNode root) {

        TreeNode preNode = new TreeNode(0);
        TreeNode res = preNode;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            TreeNode pop = deque.pollFirst();
            System.out.println(pop.val);
            if (pop.right != null) {
                deque.addFirst(pop.right);
            }
            if (pop.left != null) {
                deque.addFirst(pop.left);
            }
            preNode.left = null;
            preNode.right = pop;
            preNode = pop;

        }

        return res.right;
    }


    public static void main(String[] args) {
        TreeNode left000 = new TreeNode(-4);
        TreeNode left00 = new TreeNode(-3, left000, null);
        TreeNode left01 = new TreeNode(-2);
        TreeNode left0 = new TreeNode(-1, left00, left01);
        TreeNode right001 = new TreeNode(3);
        TreeNode right000 = new TreeNode(1);
        TreeNode right00 = new TreeNode(2, right000, right001);
        TreeNode right0 = new TreeNode(4, right00, null);
        TreeNode root = new TreeNode(0, left0, right0);
        Flatten toList = new Flatten();
        toList.flatten(root);
    }
}
