package com.pmb.code.datastructure.tree.BTS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class KthLargest {
    List<Integer> arrays;
    Integer k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        arrays = new ArrayList<Integer>();
        if (nums != null) {
            Arrays.sort(nums);
            for (int num : nums) {
                arrays.add(num);
            }
        }
    }

    public int add(int val) {
        //频繁插入元素导致扩容与拷贝
        arrays.add(getIndex(val, 0, arrays.size() - 1), val);
        return arrays.get(arrays.size() - k);
    }

    private int getIndex(int val, int start, int end) {
        if (arrays.isEmpty()) {
            return start;
        }
        if (start == end) {
            if (val > arrays.get(start)) {
                return start + 1;
            }
            return start;
        }

        int mid = (start + end) >> 1;

        Integer midValue = arrays.get(mid);
        if (midValue == val) {
            return mid;
        } else if (midValue > val) {
            return getIndex(val, start, mid);
        } else {
            return getIndex(val, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(1, null);
        kthLargest.add(-3);
        kthLargest.add(-2);
        kthLargest.add(-4);
        kthLargest.add(0);
        kthLargest.add(4);
    }


}
