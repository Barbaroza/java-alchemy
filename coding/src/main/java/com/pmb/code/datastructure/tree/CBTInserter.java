package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.cn/problems/NaqhDT/solution/
 *
 * @author lvrui
 */
public class CBTInserter {
    Map<Integer, TreeNode> index2Node = new HashMap<>();
    int size = 0;

    public CBTInserter(TreeNode root) {
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            int layer = deque.size();
            while (layer > 0) {
                TreeNode t = deque.removeFirst();
                index2Node.put(++size, t);

                if (t.left != null) {
                    deque.addLast(t.left);
                }
                if (t.right != null) {
                    deque.addLast(t.right);
                }

                layer--;
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        index2Node.put(++size, node);
        TreeNode p = index2Node.get(size / 2);
        if ((size & 1) == 1) {
            p.right = node;
        } else {
            p.left = node;
        }

        return p.val;

    }

    public TreeNode get_root() {
        return index2Node.get(1);
    }
}
