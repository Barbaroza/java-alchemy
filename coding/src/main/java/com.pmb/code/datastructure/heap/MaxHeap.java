package com.pmb.code.datastructure.heap;

public class MaxHeap<T extends Comparable<T>> {
    private T[] data;
    private int capacity;
    private int count;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Comparable[capacity + 1];
        this.count = 0;
    }

    public boolean insert(T t) {
        if (count + 1 >= capacity) {
            return false;
        }
        count++;
        data[count] = t;
        shiftUp(count);
        return true;
    }

    public T getMax() {
        T t = data[1];
        swap(1, count);
        count--;
        shiftDown(1);
        return t;
    }

    private void shiftDown(int i) {
        while (i * 2 <= count) {
            int j = 2 * i; // 在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }
            // data[j] 是 data[2*k]和data[2*k+1]中的最大值

            if (data[i].compareTo(data[j]) >= 0) {
                break;
            }
            swap(i, j);
            i = j;
        }
    }


    private void shiftUp(int count) {
        while (count > 1 && data[count].compareTo(data[count / 2]) > 0) {
            swap(count, count / 2);
            count /= 2;
        }
    }

    private void swap(int i, int j) {
        T temp = data[j];
        data[j] = data[i];
        data[i] = temp;
    }

}
