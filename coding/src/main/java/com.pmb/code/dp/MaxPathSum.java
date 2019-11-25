package com.pmb.code.dp;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * @author lvrui
 */
public class MaxPathSum {

    public static int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        dfs(root, res);
        return res[0];
    }

    private static int dfs(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int maxLeft = dfs(root.left, res);
        int maxRight = dfs(root.right, res);
        int maxPath = root.val + (maxLeft < 0 ? 0 : maxLeft) + (maxRight < 0 ? 0 : maxRight);
        res[0] = res[0] > maxPath ? res[0] : maxPath;
        return root.val + Math.max(maxLeft, Math.max(maxRight, 0));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * [186,419,83,408]
     * 6249
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.right = root1;
        root.left = root2;
        int b = MaxPathSum.maxPathSum(root);
        b++;
    }

}
