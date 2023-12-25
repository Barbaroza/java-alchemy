package com.pmb.code.datastructure.tree.deserial;

/**
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * @wait-v
 * @author Administrator
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        return buildTree(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode buildTree(int ps, int pe, int is, int ie, int[] preorder, int[] inorder) {
        TreeNode cur = null;

        if (ps > pe || is > ie) {
            return cur;
        }
        cur = new TreeNode(preorder[ps]);
        int index = index(cur.val, inorder);
        int leftLength = index - is;


        cur.left = buildTree(ps + 1, ps + leftLength, is, index - 1, preorder, inorder);
        cur.right = buildTree(ps + leftLength + 1, pe, index + 1, ie, preorder, inorder);

        return cur;
    }

    private int index(int nodeVal, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == nodeVal) {
                return i;
            }
        }

        throw new IllegalStateException("can't find nodeVal:" + nodeVal);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        TreeNode treeNode = buildTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
