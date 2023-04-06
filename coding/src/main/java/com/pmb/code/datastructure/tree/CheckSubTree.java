package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/check-subtree-lcci/submissions/
 * @author lvrui
 */
public class CheckSubTree {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        StringBuilder str1 = subsequence(t1);
        StringBuilder str2 = subsequence(t2);
        return str1.indexOf(str2.toString())!=-1;
    }

    public StringBuilder subsequence(TreeNode root){
        StringBuilder str=new StringBuilder();
        Deque<TreeNode> stack=new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if(pop==null){
                str.append("x");
                continue;
            }
            str.append(pop.val);
            stack.push(pop.right);
            stack.push(pop.left);
        }
        return str;
    }

    public boolean checkSubTree2(TreeNode t1, TreeNode t2) {

        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 ==null){
            return false;
        }
        if(t1.val == t2.val && compare(t1,t2)){
            return true;
        }

        return checkSubTree2(t1.left,t2) || checkSubTree2(t1.right,t2);
    }



    private boolean compare(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 ==null){
            return false;
        }

        if(t1.val != t2.val){
            return false;
        }

        return compare(t1.left,t2.left) && compare(t1.right,t2.right);

    }
}
