package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

/**
 * https://leetcode.cn/problems/3Etpl5/submissions/
 * @author lvrui
 */
public class SumNumbers {
    public int sumNumbers(TreeNode root) {

        return dfs(root,0);
    }

    public int dfs(TreeNode node , int pValue){
        if(node == null){
            return 0 ;
        }
        int cValue = pValue*10+node.val;
        if(node.left == null && node.right == null){
            return cValue;
        }

        return dfs(node.left,cValue) + dfs(node.right,cValue);

    }
}
