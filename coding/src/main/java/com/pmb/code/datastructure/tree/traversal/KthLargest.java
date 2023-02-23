package com.pmb.code.datastructure.tree.traversal;

import com.pmb.code.model.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

/**
 * @author lvrui
 */
public class KthLargest {
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        int ans = -1;
        while (k > 0 && (!stack.isEmpty() || cur!=null)) {
            while (cur != null) {
                stack.addFirst(cur.right);
                cur = cur.right;
            }
            TreeNode rr = stack.removeFirst();
            ans = rr.val;
            cur = rr.left;
            k--;
        }
        return ans;
    }
}
