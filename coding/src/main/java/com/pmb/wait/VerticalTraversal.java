package com.pmb.wait;

import com.pmb.code.model.TreeNode;

import java.util.*;
import java.util.function.ToIntFunction;

/**
 * 987.
 * 二叉树的垂序遍历
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * <p>
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * <p>
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * <p>
 * 返回二叉树的 垂序遍历 序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * 解释：
 * 列 -1 ：只有结点 9 在此列中。
 * 列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
 * 列  1 ：只有结点 20 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 列 -2 ：只有结点 4 在此列中。
 * 列 -1 ：只有结点 2 在此列中。
 * 列  0 ：结点 1 、5 和 6 都在此列中。
 * 1 在上面，所以它出现在前面。
 * 5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
 * 列  1 ：只有结点 3 在此列中。
 * 列  2 ：只有结点 7 在此列中。
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,6,5,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * 解释：
 * 这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
 * 因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中结点数目总数在范围 [1, 1000] 内
 * 0 <= Node.val <= 1000
 * 通过次数21,746提交次数41,019
 *
 * @author lvrui
 */
public class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, List<Integer>> temp = new TreeMap<Integer, List<Integer>>();
        Map<Integer, Integer> val2Y = new HashMap<>();
        preOrder(root, 0, 0, temp, val2Y);
        List<List<Integer>> lists = new ArrayList<>(temp.values());
        lists.forEach(nodes -> {
            nodes.sort((Comparator.comparingInt((ToIntFunction<Integer>) val2Y::get).thenComparingInt(o -> o)));
        });
        return lists;
    }

    private void preOrder(TreeNode root, int y, int x, TreeMap<Integer, List<Integer>> temp, Map<Integer, Integer> val2Y) {
        if (root == null) {
            return;
        }
        List<Integer> orDefault = temp.getOrDefault(x, new ArrayList<>());
        orDefault.add(root.val);
        temp.put(x, orDefault);
        val2Y.put(root.val, y);

        preOrder(root.right, y + 1, x + 1, temp, val2Y);
        preOrder(root.left, y + 1, x - 1, temp, val2Y);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.left = new TreeNode(3);

        VerticalTraversal verticalTraversal = new VerticalTraversal();
        verticalTraversal.verticalTraversal(treeNode);
    }
}
