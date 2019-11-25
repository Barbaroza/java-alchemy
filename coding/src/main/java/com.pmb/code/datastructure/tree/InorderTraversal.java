package com.pmb.code.datastructure.tree;

import code.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历二叉树
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author lvrui
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> queue = new Stack<TreeNode>();
        TreeNode start = root;
        while (start != null || !queue.isEmpty()) {
            while (start != null) {
                queue.add(start);
                start = start.left;
            }

            if (!queue.isEmpty()) {
                TreeNode pop = queue.pop();
                res.add(pop.val);
                if (pop.right != null) {
                    start = pop.right;
                }
            }

        }
        return res;
    }
}
