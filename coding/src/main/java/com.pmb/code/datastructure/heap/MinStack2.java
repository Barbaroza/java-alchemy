package com.pmb.code.datastructure.heap;

import java.util.Stack;

/**
 * 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * @author lvrui
 */
public class MinStack2 {

    private Stack<Integer> main;
    private Stack<Integer> min;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        this.main = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int x) {
        main.add(x);
        if (!min.isEmpty() || min.peek() >= x) {
            min.add(x);
        } else {
            min.add(min.peek());
        }
    }

    public void pop() {
        if (!main.isEmpty()) {
            min.pop();
            main.pop();
        }
    }

    public int top() {
        return this.main.peek();
    }

    public int getMin() {
        return this.min.peek();
    }

    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}
