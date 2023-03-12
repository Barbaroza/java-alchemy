package com.pmb.code.datastructure.heap;

/**
 * https://leetcode.cn/problems/xx4gT2/submissions/
 *
 * @author lvrui
 */
public class FindKthLargest {
    private int[] heap = null;
    private int cap = 0;
    private int size = 0;

    public int findKthLargest(int[] nums, int k) {
        this.cap = k;
        this.heap = new int[k + 1];

        build(nums);

        return this.heap[1];
    }


    private void build(int[] nums) {
        for (int num : nums) {
            if (size < cap) {
                heap[size + 1] = num;
                size++;
                shiftup(size);
            } else {
                if (heap[1] < num) {
                    heap[1] = num;
                    shiftdown(1);
                }
            }
        }
    }

    private void shiftdown(int i) {
        while (i * 2 <= cap) {
            int j = 2 * i;
            if (j + 1 <= cap && heap[j + 1] < heap[j]) {
                j++;
            }
            if (heap[i] < heap[j]) {
                break;
            }
            swap(i, j);
            i = j;
        }
    }


    private void shiftup(int i) {
        while (i > 1) {
            if (heap[i] > heap[i / 2]) {
                break;
            }
            swap(i, i / 2);
            i /= 2;
        }
    }


    private void swap(int i, int j) {
        int t = heap[j];
        heap[j] = heap[i];
        heap[i] = t;
    }
}
