package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/P5rCT8/
 * @author lvrui
 */
public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode pre = null;
        LinkedList<TreeNode> stack = new LinkedList();

        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.addLast(cur);
                cur = cur.left;
            }

            TreeNode  t = stack.removeLast();
            if(pre == p){
                return t;
            }
            pre = t;
            cur = t.right;

        }

        return null;

    }


    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode ans  = null;
        TreeNode cur = root;
        while(cur!=null){
            if(cur.val>p.val){
                ans = cur;
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }

        return  ans;
    }
}
