package com.pmb.code.datastructure.tree.traversal.inorder;

import com.pmb.code.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 注意：该题目与 538: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/  相同
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 示例 2：
 * <p>
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 * 示例 3：
 * <p>
 * 输入：root = [1,0,2]
 * 输出：[3,3,2]
 * 示例 4：
 * <p>
 * 输入：root = [3,2,4,1]
 * 输出：[7,9,4,10]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lvrui
 * @toTest
 */
public class BstToGst {

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            Deque<TreeNode> temp = new LinkedList<>();
            List<TreeNode> res = new ArrayList<>();
            TreeNode node = root;
            while (temp.size() > 0 || node != null) {
                while (node != null) {
                    temp.addFirst(node);
                    node = node.right;
                }
                TreeNode treeNode = temp.pollFirst();
                res.add(treeNode);
                node = treeNode.left;
            }
            int preSum = 0;
            for (TreeNode treeNode : res) {
                treeNode.val = treeNode.val + preSum;
                preSum = treeNode.val;
            }
        }
        return root;
    }


    public TreeNode bstToGst2(TreeNode root) {
        if (root == null) {
            return root;
        }

        LinkedList<TreeNode> path = new LinkedList<>();
        TreeNode cur = root;
        int res = 0;
        while (!path.isEmpty() || cur != null) {
            while (cur != null ) {
                path.addFirst(cur);
                cur = cur.right;
            }
            TreeNode treeNode = path.removeFirst();
            res += treeNode.val;
            treeNode.val = res;

            cur = cur.left;

        }


        return root;
    }

}
