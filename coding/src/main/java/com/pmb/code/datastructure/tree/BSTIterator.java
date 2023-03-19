package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/kTOapQ/solution/er-cha-sou-suo-shu-die-dai-qi-by-leetcod-hwfe/
 * @author lvrui
 */
public class BSTIterator {
    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new LinkedList<TreeNode>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }

}
