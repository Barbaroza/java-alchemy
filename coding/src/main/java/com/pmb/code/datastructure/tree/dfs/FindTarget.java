package com.pmb.code.datastructure.tree.dfs;

import com.pmb.code.model.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/opLdQZ/
 *
 * @author lvrui
 */
public class FindTarget {
    Set<Integer> access = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        int newTarget = k - root.val;
        if (access.contains(newTarget)) {
            return true;
        }
        access.add(root.val);
        boolean sign = false;
        sign = findTarget(root.left, k);
        sign = sign || findTarget(root.right, k);

        return sign;
    }
}
