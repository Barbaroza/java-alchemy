package com.pmb.wait;

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
 * @wait-v
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

    public static class MinStack2 {


        List<Integer> arr;

        int index = 0;


        public MinStack2() {
            arr = new ArrayList<>();

            arr.add(0);
        }

        public void push(int num) {
            arr.add(num);
            this.shiftUp(++index);
        }

        private void shiftUp(int index) {
            while (index != 1 && arr.get(index) < arr.get(index / 2)) {
                swap(index, index / 2);
                index = index / 2;
            }
        }

        private void shiftDown(int i) {
            while (i * 2 <= index) {
                if (i * 2 + 1 <= index && arr.get(i * 2 + 1) < arr.get(i * 2) && arr.get(i) > arr.get(i * 2 + 1)) {
                    swap(i, i * 2 + 1);
                    i = i * 2 + 1;
                    continue;
                }
                if (arr.get(i) > arr.get(i * 2)) {
                    swap(i, i * 2);
                    i *= 2;
                    continue;
                }

                break;
            }
        }


        public int pop() {
            int res = this.arr.get(1);
            this.arr.set(1, arr.get(index));
            index--;
            shiftDown(1);
            arr.remove(index + 1);
            return res;
        }

        public int top() {
            return this.arr.get(1);
        }

        public int getMin() {
            return this.top();
        }

        private void swap(int i, int d) {
            Integer temp = this.arr.get(i);
            this.arr.set(i, arr.get(d));
            this.arr.set(d, temp);
        }
    }
}
