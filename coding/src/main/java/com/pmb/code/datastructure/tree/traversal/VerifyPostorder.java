package com.pmb.code.datastructure.tree.traversal;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 *
 * @author lvrui
 */
public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return isBST(postorder, 0, postorder.length - 1);
    }

    private boolean isBST(int[] postorder, int s, int e) {
        //
        if (s >= e) {
            return true;
        }
        int i = s;
        while (postorder[e] > postorder[i]) {
            i++;
        }
        int j = i;
        while (postorder[e] < postorder[j]) {
            j++;
        }

        return j == e && isBST(postorder, s, i - 1) && isBST(postorder, i, e - 1);
    }

    public boolean verifyPostorder2(int[] postorder) {
        Integer rootVal = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > rootVal) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                rootVal = stack.pop();
            }
            stack.add(postorder[i]);
        }

        return true;
    }

    public boolean verifyPostorder3(int[] postorder) {
        Stack<Integer> stack = new Stack<>();  // 设栈，存放根节点和右子节点，一点遇到左子节点，将一直弹出它的右兄弟，直到弹出其根节点。即最后一个弹出的节点就是根节点。
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {  // 从右往左遍历，创造假设条件。
            if(postorder[i] > root) return false;        // 每一轮结束后，弹出的是根节点，在左子节点中不可能出现比根节点大的值，出现不符合条件的，直接返回，最开始的可以假设有一个虚拟的最大根节点。
            while(!stack.isEmpty() && stack.peek() > postorder[i])     // 将根节点和右节点放入栈中，出现比栈顶小的，即出现了左子节点，则弹出所有不合适做它根节点的所有值，直到弹出符合它的根节点。
                root = stack.pop();
            stack.add(postorder[i]);    //然后将这和左子节点放入堆中，成为新一轮的根节点。
        }
        return true;
    }

}
