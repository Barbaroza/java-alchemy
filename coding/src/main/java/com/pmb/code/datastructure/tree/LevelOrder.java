package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lvrui
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> deque = new LinkedList<TreeNode>();
        while (!deque.isEmpty()) {
            int temp = 0;
            int index = deque.size();
            List<Integer> tempList = new ArrayList<Integer>(index);
            while (temp < index) {
                TreeNode current = deque.poll();
                temp++;
                tempList.add(current.val);
                if (current.left != null) {
                    deque.push(current.left);
                }
                if (current.right != null) {
                    deque.push(current.right);
                }
            }
            res.add(tempList);

        }
        return res;

    }
}
