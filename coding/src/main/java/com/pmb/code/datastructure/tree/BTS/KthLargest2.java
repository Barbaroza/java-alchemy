package com.pmb.code.datastructure.tree.BTS;

/**
 * Kth Largest Element in a Stream
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * <p>
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * <p>
 * 示例:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 *
 * @author lvrui
 */
public class KthLargest2 {
    int[] heap;

    //heap数组中实际存放的元素数量
    int size = 0;

    public KthLargest2(int k, int[] nums) {
        heap = new int[k];
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (size < heap.length) {
            size++;
            heap[size - 1] = val;

            if (size == heap.length) {
                //构建小顶堆
                makeMinHeap();
            }

        } else {
            if (heap[0] < val) {
                //替换堆顶元素
                heap[0] = val;
                minHeapFixdown(0);
            }
        }

        return heap[0];
    }

    /**
     * 堆化heap数组，建立最小堆
     */
    private void makeMinHeap() {
        int length = heap.length;
        //第一个非叶子节点为什么是(length / 2) - 1呢？
        for (int i = (length / 2) - 1; i >= 0; i--) {
            minHeapFixdown(i);
        }
    }

    /**
     * 从i节点开始调整, i节点的子节点为 2*i+1, 2*i+2
     *
     * @param i 第i个节点
     */
    public void minHeapFixdown(int i) {
        int temp = heap[i];
        //子节点是多少？i节点的子节点为 2*i+1, 2*i+2
        int subLeft = 2 * i + 1;
        while (subLeft < heap.length) {
            int subRight = subLeft + 1;
            if (subRight < heap.length && heap[subLeft] > heap[subRight]) {
                subLeft++;
            }

            if (heap[subLeft] >= heap[i]) {
                break;
            }
            heap[i] = heap[subLeft];
            heap[subLeft] = temp;

            i = subLeft;
            subLeft = 2 * i + 1;
        }

    }


}
