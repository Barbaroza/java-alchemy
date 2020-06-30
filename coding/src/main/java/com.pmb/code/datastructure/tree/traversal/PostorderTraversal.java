package com.pmb.code.datastructure.tree.traversal;

import com.pmb.code.model.TreeNode;

import java.util.*;

/**
 * 5. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lvrui
 * @star
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null && !set.contains(cur)) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            //右子树为空或者第二次来到这里
            if (cur.right == null || set.contains(cur)) {
                list.add(cur.val);
                set.add(cur);
                stack.pop();//将当前节点弹出
                if (stack.isEmpty()) {
                    return list;
                }
                //转到右子树，这种情况对应于右子树为空的情况
                cur = stack.peek();
                cur = cur.right;
                //从左子树过来，加到 set 中，转到右子树
            } else {
                set.add(cur);
                cur = cur.right;
            }
        }
        return list;

    }

    List<Integer> pop(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        Set<TreeNode> set = new HashSet<>();

        if (current == null) {
            return res;
        }

        while (current != null || !stack.isEmpty()) {
            while (current != null && !set.contains(current)) {
                stack.push(current);
                current = current.left;
            }
            current = stack.peek();
            if (current.right == null || set.contains(current)) {
                res.add(current.val);
                set.add(current);
                stack.pop();
                if (stack.isEmpty()) {
                    return res;
                }
                current = stack.peek().right;

            } else {
                res.add(current.val);
                current = current.right;
            }
        }

        return res;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

}
