package com.pmb.wait.wait_2023_02_02;

import com.pmb.code.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * @author lvrui
 */
public class TreeSolution {
    public int[] preorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }


        Stack<TreeNode> stack = new Stack<TreeNode>();

        List<Integer> temp = new ArrayList<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            if (pop.right != null) {
                stack.add(pop.right);
            }
            if (pop.left != null) {
                stack.add(pop.left);
            }

            temp.add(pop.val);
        }
        int[] ans = new int[temp.size()];

        IntStream.range(0, ans.length).forEach(i -> {
            ans[i] = temp.get(i);
        });
        return ans;


    }


    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && dfsSummary(0, sum, root);
    }

    private boolean dfsSummary(int cur, int target, TreeNode node) {
        if (node == null) {
            return cur == target;
        }

        int now = cur + node.val;

        if (node.right == null && node.left == null) {
            return target == now;
        }


        boolean rExist = node.right != null && dfsSummary(now, target, node.right);
        boolean lExist = node.left != null && dfsSummary(now, target, node.left);

        return rExist || lExist;

    }

    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) {
            return null;
        }
        List<TreeNode> temp = new ArrayList<>();


        recursive(pRootOfTree, temp);

        TreeNode vNode = new TreeNode(-1);
        TreeNode pre = vNode;

        for (int i = 0; i < temp.size(); i++) {
            TreeNode cur = temp.get(i);
            pre.right = cur;
            cur.left = pre;
            pre = cur;

        }
        vNode.right.left = null;
        return vNode.right;
    }


    private void recursive(TreeNode node, List<TreeNode> temp) {

        if (node == null) {
            return;
        }


        recursive(node.left, temp);
        temp.add(node);

        recursive(node.right, temp);


    }

    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || bfs(pRoot);
    }


    private boolean bfs(TreeNode pRoot) {
        LinkedList<TreeNode> queue = new LinkedList();
        queue.addFirst(pRoot);
        TreeNode vNode = new TreeNode(-1001);
        while (!queue.isEmpty()) {

            int[] temp = new int[queue.size()];

            for (int i = 0; i < temp.length; i++) {
                TreeNode cur = queue.removeFirst();
                temp[i] = cur.val;
                if (vNode != cur) {
                    queue.addLast(cur.left != null ? cur.left : vNode);
                    queue.addLast(cur.right != null ? cur.right : vNode);
                }

            }
            if (!isMirror(temp)) {
                return false;
            }


        }

        return true;

    }


    private boolean isMirror(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        boolean ans = true;

        while (l < r && ans) {
            ans = nums[r] == nums[l];

            l++;
            r--;
        }
        return ans;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if (pre == null || pre.length == 0 || pre.length != vin.length) {
            return null;
        }


        return restore(pre, vin, 0, vin.length - 1, 0, vin.length - 1);
    }

    private TreeNode restore(int[] pre, int[] vin, int pl, int pr, int vl, int vr) {

        int nodeVal = pre[pl];

        TreeNode node = new TreeNode(nodeVal);

        if (pl == pr) {
            return node;
        }

        int index = index(vin, vl, vr, nodeVal);

        int leftLength = index - vl;

        int rightLength = vr - index;

        if (leftLength > 0) {
            node.left = restore(pre, vin, pl + 1, pl + leftLength, vl, index - 1);
        }

        if (rightLength > 0) {
            node.right = restore(pre, vin, leftLength + pl + 1, pr, index + 1, vr);
        }

        return node;


    }

    private int index(int[] vin, int vl, int vr, int nodeVal) {
        for (int i = vl; i <= vr; i++) {
            if (vin[i] == nodeVal) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeSolution treeSolution = new TreeSolution();
        treeSolution.reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }


}
