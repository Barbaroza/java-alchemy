package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lvrui
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        List<TreeNode> layerNodes = new ArrayList<>();
        while (!deque.isEmpty()) {
            TreeNode pop = deque.pop();
            if (pop.left != null) {
                layerNodes.add(pop.left);
            }
            if (pop.right != null) {
                layerNodes.add(pop.right);
            }

            if (deque.isEmpty()) {
                res.add(pop.val);
                if (!layerNodes.isEmpty()) {
                    deque.addAll(layerNodes);
                    layerNodes.clear();
                }
            }
        }
        return res;
    }
}
