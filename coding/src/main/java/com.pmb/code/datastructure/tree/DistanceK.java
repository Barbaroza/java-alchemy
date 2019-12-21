package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

import java.util.*;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * 题目描述
 * 评论 (60)
 * 题解(26)
 * 提交记录
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * <p>
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * <p>
 * 输出：[7,4,1]
 * <p>
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * <p>
 * <p>
 * <p>
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的树是非空的，且最多有 K 个结点。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 *
 * @author lvrui
 */
public class DistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = null;
        if (root != null && K >= 0) {
            res = new ArrayList<>();
            Map<TreeNode, TreeNode> temp = new HashMap<>();
            dfsParent(root, target, temp);
            Set<TreeNode> unique = new HashSet<>();
            dfsStep(target, temp, unique, K, res);
        }
        return res;
    }

    private void dfsStep(TreeNode target, Map<TreeNode, TreeNode> temp, Set<TreeNode> unique, int k, List<Integer> res) {
        if (target == null) {
            return;
        }
        if (!unique.add(target)) {
            return;
        }
        if (k == 0) {
            res.add(target.val);
        }
        if (k > 0) {
            dfsStep(target.left, temp, unique, k - 1, res);
            dfsStep(target.right, temp, unique, k - 1, res);
            dfsStep(temp.get(target), temp, unique, k - 1, res);
        }
    }

    private void dfsParent(TreeNode root, TreeNode target, Map<TreeNode, TreeNode> temp) {
        if (root.val == target.val) {
            return;
        }
        if (root.left != null) {
            temp.put(root.left, root);
            dfsParent(root.left, target, temp);
        }
        if (root.right != null) {
            temp.put(root.right, root);
            dfsParent(root.right, target, temp);
        }
    }

}
