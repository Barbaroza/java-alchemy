package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

/**
 * https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/?favorite=xb9nqhhg
 * @author lvrui
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {

        if(root == null){
            return null;
        }

        TreeNode right = mirrorTree(root.left);
        TreeNode left =  mirrorTree(root.right);

        root.left = left;
        root.right = right;


        return root;
    }
}
