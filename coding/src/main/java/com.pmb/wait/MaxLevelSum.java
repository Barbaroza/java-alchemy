package com.pmb.wait;

import com.pmb.code.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161. 最大层内元素和
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：[1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数介于 1 和 10^4 之间
 * -10^5 <= node.val <= 10^5
 *
 * @author lvrui
 */
public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {

        int maxLevel = 0;
        if (root == null) {
            return maxLevel;
        }
        maxLevel = 1;
        int currentNodeNum = 1;
        int currentLayerNum = 1;
        int maxSum = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nextLayerNum = 0;
            int currentSum = 0;
            while (currentNodeNum > 0) {
                TreeNode remove = queue.remove();
                currentSum += remove.val;
                if (remove.left != null) {
                    nextLayerNum++;
                    queue.add(remove.left);
                }
                if (remove.right != null) {
                    nextLayerNum++;
                    queue.add(remove.right);
                }
                currentNodeNum--;
            }
            if (currentSum > maxSum) {
                maxLevel = currentLayerNum;
                maxSum = currentSum;
            }
            currentNodeNum = nextLayerNum;
            currentLayerNum++;

        }
        return maxLevel;

    }

    public int maxLevelSum2(TreeNode root) {
        int[] layerSum = new int[10000];
        dfs(root, 1, layerSum);
        int index = 1;
        int maxSum = layerSum[index];
        int maxLayer = index;
        for (; index < 10000; index++) {
            if (layerSum[index] > maxSum) {
                maxSum = layerSum[index];
                maxLayer = index;
            }
        }

        return maxLayer;
    }

    private void dfs(TreeNode root, int i, int[] layerSum) {
        if (root != null) {

            layerSum[i] += root.val;
            dfs(root.right, i + 1, layerSum);
            dfs(root.left, i + 1, layerSum);
        }

    }


}
