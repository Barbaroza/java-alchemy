package com.pmb.code.datastructure.tree;

import com.pmb.code.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。
 * <p>
 * 回想一下：
 * <p>
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，<font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace">S</font> 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 * <p>
 * 输入：root = [1,2,3,4]
 * 输出：[4]
 * 示例 3：
 * <p>
 * 输入：root = [1,2,3,4,5]
 * 输出：[2,4,5]
 *  
 * <p>
 * 提示：
 * <p>
 * 给你的树中将有 1 到 1000 个节点。
 * 树中每个节点的值都在 1 到 1000 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lvrui
 */
public class LcaDeepestLeaves {
    /**
     * 比较粗暴
     * dfs 找到叶子节点最长路径集合
     * 根据最长路径找到最近的公共祖先
     *
     * @param root
     * @return
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {

        if (root == null) {
            return root;
        }
        Stack<TreeNode> path = new Stack<TreeNode>();
        List<List<TreeNode>> maxPaths = new ArrayList<>();
        dfs(path, maxPaths, root);
        TreeNode res = root;
        int size = maxPaths.get(0).size();
        for (int index = 0; index < size; index++) {
            TreeNode current = maxPaths.get(0).get(index);
            for (List<TreeNode> list : maxPaths) {
                if (current != list.get(index)) {
                    return res;
                }
            }
            res = maxPaths.get(0).get(index);
        }
        return res;
    }

    private void dfs(Stack<TreeNode> path, List<List<TreeNode>> maxPaths, TreeNode root) {
        path.add(root);
        if (root.left != null) {
            dfs(path, maxPaths, root.left);
        }
        if (root.right != null) {
            dfs(path, maxPaths, root.right);
        }
        if (root.left == null && root.right == null) {
            if (maxPaths.isEmpty()) {
                maxPaths.add(new ArrayList<>(path));
            } else {
                int size = path.size();
                int originSize = maxPaths.get(0).size();
                if (originSize == size) {
                    maxPaths.add(new ArrayList<>(path));

                } else if (originSize < size) {
                    maxPaths.clear();
                    maxPaths.add(new ArrayList<>(path));

                }
            }

        }
        path.pop();
    }
}
