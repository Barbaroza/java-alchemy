package com.pmb.code.datastructure.stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * @author lvrui
 */
public class CQueue {
    Stack<Integer> stack = new Stack();
    Stack<Integer> stack2 = new Stack();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack.add(value);
    }

    public int deleteHead() {
        if (stack.isEmpty() && stack2.isEmpty()) {
            return -1;
        }

        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack.isEmpty()) {
            stack2.add(stack.pop());
        }

        return stack2.pop();

    }
}
