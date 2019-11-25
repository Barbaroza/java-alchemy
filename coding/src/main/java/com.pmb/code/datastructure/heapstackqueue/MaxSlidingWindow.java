package com.pmb.code.datastructure.heapstackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 注意：
 * <p>
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 *
 * @author lvrui
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> tempQueue = new ArrayDeque<>(k);
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i <= k - 1) {
                tempQueue.add(nums[i]);
                int poll = tempQueue.removeLast();
            } else {
                tempQueue.add(nums[i]);
                if (firstMax < nums[i]) {
                    secondMax = firstMax;
                    firstMax = nums[i];
                } else if (secondMax < nums[i]) {
                    secondMax = nums[i];
                }
            }
        }
        return res;
    }

    /*
      思路： 遍历数组 L R 为滑窗左右边界 只增不减
            双向队列保存当前窗口中最大的值的数组下标 双向队列中的数从大到小排序，
            新进来的数如果大于等于队列中的数 则将这些数弹出 再添加
            当R-L+1=k 时 滑窗大小确定 每次R前进一步L也前进一步 保证此时滑窗中最大值的
            数组下标在[L，R]中，并将当前最大值记录
      举例： nums[1，3，-1，-3，5，3，6，7] k=3
         1：L=0，R=0，队列【0】 R-L+1 < k
                队列代表值【1】
         2: L=0,R=1, 队列【1】 R-L+1 < k
                队列代表值【3】
         解释：当前数为3 队列中的数为【1】 要保证队列中的数从大到小 弹出1 加入3
              但队列中保存的是值对应的数组下标 所以队列为【1】 窗口长度为2 不添加记录
         3: L=0,R=2, 队列【1，2】 R-L+1 = k ,result={3}
                队列代表值【3，-1】
         解释：当前数为-1 队列中的数为【3】 比队列尾值小 直接加入 队列为【3，-1】
              窗口长度为3 添加记录记录为队首元素对应的值 result[0]=3
         4: L=1,R=3, 队列【1，2，3】 R-L+1 = k ,result={3，3}
                队列代表值【3，-1,-3】
         解释：当前数为-3 队列中的数为【3，-1】 比队列尾值小 直接加入 队列为【3，-1，-3】
              窗口长度为4 要保证窗口大小为3 L+1=1 此时队首元素下标为1 没有失效
              添加记录记录为队首元素对应的值 result[1]=3
         5: L=2,R=4, 队列【4】 R-L+1 = k ,result={3，3，5}
                队列代表值【5】
         解释：当前数为5 队列中的数为【3，-1，-3】 保证从大到小 依次弹出添加 队列为【5】
              窗口长度为4 要保证窗口大小为3 L+1=2 此时队首元素下标为4 没有失效
              添加记录记录为队首元素对应的值 result[2]=5
        依次类推 如果队首元素小于L说明此时值失效 需要弹出
    */
    public int[] maxSlidingWindow2(int[] nums, int k) {

        if (nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> list = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小 弹出
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();
            }
            // 添加当前值对应的数组下标
            list.addLast(i);
            // 初始化窗口 等到窗口长度为k时 下次移动在删除过期数值
            if (list.peek() <= i - k) {
                list.poll();
            }
            // 窗口长度为k时 再保存当前窗口中最大值
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[list.peek()];
            }
        }
        return result;
    }


    public int[] slide(int[] arr, int n, int w) {
        int[] result = new int[n - w + 1];
        Deque<Integer> window = new ArrayDeque<>();
        //初始化宽度为w的滑动窗口
        int i = 0;
        for (; i < w; i++) {
            if (!window.isEmpty() && arr[i] > arr[window.getLast()]) {
                while (!window.isEmpty() && arr[window.getLast()] < arr[i]) {
                    window.removeLast();
                }
            }
            window.addLast(i);
        }
        int size = 0;
        result[size] = arr[window.getFirst()];

        //依次进行滑动
        for (; i < n; i++) {
            if (i - window.getFirst() == w) {
                window.removeFirst();
            }

            if (!window.isEmpty() && arr[i] > arr[window.getLast()]) {
                while (!window.isEmpty() && arr[window.getLast()] < arr[i]) {
                    window.removeLast();
                }
            }
            window.addLast(i);
            result[++size] = arr[window.getFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        maxSlidingWindow.maxSlidingWindow2(new int[]{5, 2, 3, 8, 9, 4, 3}, 4);
    }
}
