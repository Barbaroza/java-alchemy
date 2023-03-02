package com.pmb.code.datastructure.tree;


import com.pmb.code.model.TreeNode;

/**
 * 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 先序：1 2 4 6 7 8 3 5
 * 中序：4 7 6 8 2 1 3 5
 * 后序：7 8 6 4 2 5 3 1
 *
 * @author lvrui
 * @star
 */
public class BuildTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode = null;
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return treeNode;
        }
        return buildCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildCore(int[] preorder, int preSt, int preEnd, int[] inorder, int inSt, int inEnd) {
        //前序遍历第一个节点是根节点
        int rootValue = preorder[preSt];
        TreeNode root = new TreeNode(rootValue);

        //前序序列只有根节点
        if (preSt == preEnd) {
            return root;
        }
        //遍历中序序列，找到根节点的位置
        int rootInorder = inSt;
        while (inorder[rootInorder] != rootValue && rootInorder <= inEnd) {
            rootInorder++;
        }

        //左子树的长度
        int leftLength = rootInorder - inSt;
        //前序序列中左子树的最后一个节点
        int leftPreEnd = preSt + leftLength;

        //左子树非空
        if (leftLength > 0) {
            //重建左子树
            root.left = buildCore(preorder, preSt + 1, leftPreEnd, inorder, inSt, inEnd);
        }
        //右子树非空
        if (leftLength < preEnd - preSt) {
            //重建右子树
            root.right = buildCore(preorder, leftPreEnd + 1, preEnd, inorder, rootInorder + 1, inEnd);
        }
        return root;
    }


    public static void main(String[] args) {
        int[] p = new int[]{1, 2, 4, 6, 7, 8, 3, 5};
        int[] i = new int[]{4, 7, 6, 8, 2, 1, 3, 5};
        TreeNode treeNode = buildTree2(p, i);
        treeNode = null;
    }

    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        // preorder 为空，直接返回 null
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }
        int leftNum = i_root_index - i_start;
        //递归的构造左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        //递归的构造右子树
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }

    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        return buildNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    private TreeNode buildNode(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl < 0 || pl > preorder.length - 1 || il < 0 || ir > inorder.length - 1 || pl > pr || il > ir) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);

        int inorderIndex = indexOf(inorder, il, ir, preorder[pl]);
        int leftNodeNum = inorderIndex - il;
        root.left = buildNode(preorder, pl + 1, pl + leftNodeNum, inorder, il, inorderIndex);
        root.right = buildNode(preorder, pl + leftNodeNum + 1, pr, inorder, inorderIndex + 1, ir);
        return root;
    }

    private int indexOf(int[] arr, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (value == arr[i]) {
                return i;
            }
        }

        return -1;
    }
}
