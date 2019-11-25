package com.pmb.code;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author lvrui
 */
public class BinaryTreeDemo {
    public static class Node {
        public Node left;
        public Node right;
        public int val;
    }

    public int getHeight(Node root) {

        int[] res = new int[]{0};
        Stack<Node> stack = new Stack<Node>();
        getHeight(root, res, stack);
        return res[0];
    }

    private void getHeight(Node root, int[] res, Stack<Node> stack) {
        if (root == null) {
            return;
        }
        stack.push(root);
        res[0] = Math.max(res[0], stack.size());
        getHeight(root.right, res, stack);
        getHeight(root.left, res, stack);
        stack.pop();
    }

    public static int getMaxDepth(Node root) {
        if (root == null) {
            return 0;
        } else {
            int left = getMaxDepth(root.left);
            int right = getMaxDepth(root.right);
            return 1 + Math.max(left, right);
        }
    }
    public static int getMaxWidth(Node root) {
        if (root == null)
            return 0;

        Queue<Node> queue = new ArrayDeque<Node>();
        int maxWitdth = 1; // 最大宽度
        queue.add(root); // 入队

        while (true) {
            int len = queue.size(); // 当前层的节点个数
            if (len == 0)
                break;
            while (len > 0) {// 如果当前层，还有节点
                Node t = queue.poll();
                len--;
                if (t.left != null)
                    queue.add(t.left); // 下一层节点入队
                if (t.right != null)
                    queue.add(t.right);// 下一层节点入队
            }
            maxWitdth = Math.max(maxWitdth, queue.size());
        }
        return maxWitdth;
    }
    public static int getWidth(Node root) {
        if(root == null) return 0;
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        int count = 1; //每层的结点数
        int width = 1; //宽度
        while(!list.isEmpty()) {
            int size = 0; //临时保存下层的结点数
            for(int i = 0; i < count; i++) {
                Node p = list.removeFirst();
                if(p.left != null) {
                    size++;
                    list.addLast(p.left);
                }
                if(p.right != null) {
                    size++;
                    list.addLast(p.right);
                }
            }
            if(size == 0) break; //如果下一层没有结点，则结束循环
            if(size > width) width = size;
            count = size;
        }
        return width;
    }

    public static int getDeep(Node root) {
        if(root == null) return 0;
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        int count = 1; //每层的结点数
        int level = 1; //层数
        while(!list.isEmpty()) {
            int size = 0; //临时保存下层的结点数
            for(int i = 0; i < count; i++) {
                Node p = list.removeFirst();
                if(p.left != null) {
                    size++;
                    list.addLast(p.left);
                }
                if(p.right != null) {
                    size++;
                    list.addLast(p.right);
                }
            }
            //如果下一层没有结点，则结束循环
            if(size == 0) break;
            count = size;
            level++;
        }
        return level;
    }
    public static void main(String[] args) {
        Node root = new Node();
        Node left = new Node();
        root.right = new Node();
        root.left = left;
        left.left = new Node();

        BinaryTreeDemo demo = new BinaryTreeDemo();
        int a = demo.getHeight(root);
        a = 0;
    }
}
