package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @star
 * @author lvrui
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> current = new ArrayList<Integer>();
        if (root == null) {
            return current;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.right != null) {
                stack.push(pop.right);

            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
            current.add(pop.val);
        }
        return current;
    }

}
