package com.pmb.code.model;

/**
 * @author lvrui
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;


    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.right = right;
        this.left = left;
    }

}