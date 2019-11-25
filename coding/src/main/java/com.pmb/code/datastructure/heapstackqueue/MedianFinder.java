package com.pmb.code.datastructure.heapstackqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * @author lvrui
 */
public class MedianFinder {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    private Integer size = 0;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (this.size % 2 == 0) {
            this.maxHeap.offer(num);
            this.minHeap.offer(maxHeap.poll());
        } else {
            this.minHeap.offer(num);
            this.maxHeap.offer(minHeap.poll());

        }
        this.size++;
    }

    public double findMedian() {
        if (this.size % 2 == 0) {
            return new Double(maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(4);
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double res = medianFinder.findMedian();
        medianFinder.addNum(10);
        res = medianFinder.findMedian();
    }

}
