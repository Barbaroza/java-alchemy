package com.pmb.code.datastructure.stack;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/sort-of-stacks-lcci/solution/by-ma-33-f3hb/
 * @author lvrui
 */
public class MinStack {
    LinkedList<Integer> deque = new LinkedList();
    LinkedList<Integer> minDeque = new LinkedList();

    public MinStack() {

    }

    public void push(int x) {
        deque.addFirst(x);
        int w = x;
        if (!minDeque.isEmpty()) {
            w = Math.min(x, minDeque.getFirst());
        }
        minDeque.addFirst(w);

    }

    public void pop() {
        if (!deque.isEmpty()) {
            minDeque.removeFirst();
            deque.removeFirst();
        }

    }

    public int top() {
        return deque.isEmpty() ? -1 : deque.peek();
    }

    public int min() {
        return minDeque.isEmpty() ? -1 : minDeque.peek();

    }
}
