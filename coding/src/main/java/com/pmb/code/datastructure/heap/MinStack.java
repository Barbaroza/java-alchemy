package com.pmb.code.datastructure.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class MinStack {

    List<Integer> data;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new ArrayList<Integer>();
        data.add(0);
    }

    public void push(int x) {
        data.add(x);
        shiftUp();
    }

    private void shiftUp() {
        int c = data.size() - 1;
        int j = data.size() / 2;

        while (j >= 1 && data.get(c) < data.get(j)) {
            Collections.swap(data, c, j);
            c = j;
            j = c / 2;
        }
    }

    public void pop() {
        if (data.size() < 2) {
            return;
        }
        Collections.swap(data, 1, data.size() - 1);
        data.remove(data.size() - 1);
        shiftDown();
    }

    private void shiftDown() {
        int k = 1;
        int j = 2 * k;
        while (j < data.size()) {
            if (j + 1 < data.size() && data.get(j) > data.get(j + 1)) {
                j++;
            }
            if (data.get(j) < data.get(k)) {
                Collections.swap(data, j, k);
            }
            k = j;
            j = 2 * k;
        }
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        return data.get(1);
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-1);
        int a = s.getMin();
        s.pop();
        int c = s.top();
        int b = s.getMin();
    }

}
