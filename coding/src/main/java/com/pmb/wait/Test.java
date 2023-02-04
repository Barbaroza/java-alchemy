package com.pmb.wait;

import com.pmb.code.model.ListNode;
import com.pmb.code.model.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author lvrui
 */
public class Test {


    public static int findMax(int[] arr) {
        int res = Integer.MIN_VALUE;
        if (arr == null || arr.length < 3) {
            return res;
        }
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int middle = start + (end - start) / 2;

            if (arr[middle] > arr[middle + 1] && arr[middle] > arr[middle - 1]) {
                res = arr[middle];
                break;
            }
            if (arr[middle] < arr[middle - 1]) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return res;
    }

    public void dfs1(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(treeNode);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.left != null) {
                stack.add(pop.right);
            }
            if (pop.right != null) {
                stack.add(pop.left);
            }
        }
    }

    public void dfs2(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = treeNode;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current.left);
                current = current.left;
            }
            if (!stack.empty()) {
                TreeNode temp = stack.pop();
                current = temp.right;
            }
        }
    }

    public List<Integer> postorderTraversal(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        stack.addFirst(node);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pollFirst();
            res.addFirst(treeNode.val);
            if (treeNode.right != null) {
                stack.addFirst(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.addFirst(treeNode.left);
            }
        }
        return res;
    }

    public void bfs(TreeNode node) {
        LinkedList<TreeNode> temp = new LinkedList<>();
        temp.add(node);
        while (!temp.isEmpty()) {
            int size = temp.size();
            while (size > 0) {
                TreeNode poll = temp.removeFirst();
                if (poll.right != null) {
                    temp.addLast(poll.right);
                }

                if (poll.left != null) {
                    temp.addLast(poll.left);
                }
                size--;
            }
        }
    }

    public void reserve(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode pre = null;
        ListNode current = node;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return;
    }


    public static boolean isUgly(int num) {
        int div = num;
        while (div != 1) {
            if (div % 2 == 0) {
                div /= 2;
            } else if (div % 5 == 0) {
                div /= 5;
            } else if (div % 3 == 0) {
                div /= 3;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        isUgly(6);
    }


    public class SortedWrapper {
        int min;
        int max;
        public int[] sortedArr;

        public SortedWrapper(int min, int max, int[] sortedArr) {
            this.min = min;
            this.max = max;
            this.sortedArr = sortedArr;
        }
    }

    public void topThree(int[][] sorted, int[] res) {
        if (sorted == null || res == null) {
            return;
        }
        List<SortedWrapper> toSortList = new LinkedList();
        for (int[] sortedArr : sorted) {
            toSortList.add(new SortedWrapper(sortedArr[0], sortedArr[sortedArr.length - 1], sortedArr));
        }
        Collections.sort(toSortList, (o1, o2) -> {
                    return o1.min - o2.min;
                }
        );


    }
}
