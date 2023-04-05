package com.pmb.code.datastructure.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/stack-of-plates-lcci/
 * @author lvrui
 */
public class StackOfPlates {
    List<LinkedList<Integer>> stackArr;
    int cap;

    public StackOfPlates(int cap) {
        this.cap = cap;
        stackArr = new ArrayList<>();
    }

    public void push(int val) {
        if (this.cap == 0) {
            return;
        }
        if (stackArr.size() == 0) {
            stackArr.add(new LinkedList());
        }
        LinkedList<Integer> stack = stackArr.get(stackArr.size() - 1);
        if (stack.size() == this.cap) {
            stack = new LinkedList<>();
            stackArr.add(stack);
        }
        stack.addLast(val);
    }

    public int pop() {
        while (stackArr.size() > 0) {
            LinkedList<Integer> stack = stackArr.get(stackArr.size() - 1);
            if (stack.isEmpty()) {
                stackArr.remove(stackArr.size() - 1);
            } else {
                int ans = stack.removeLast();
                if (stack.isEmpty()) {
                    stackArr.remove(stackArr.size() - 1);
                }
                return ans;
            }
        }
        return -1;
    }

    public int popAt(int index) {

        while (index < stackArr.size()) {
            LinkedList<Integer> stack = stackArr.get(index);
            if (stack.isEmpty()) {
                stackArr.remove(index);
            } else {
                int ans = stack.removeLast();
                if (stack.isEmpty()) {
                    stackArr.remove(index);
                }
                return ans;
            }

        }

        return -1;
    }


}
