package com.pmb.code.datastructure.tree.brt;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/
 * 352. 将数据流变为多个不相交区间
 * 给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。
 * <p>
 * 实现 SummaryRanges 类：
 * <p>
 * SummaryRanges() 使用一个空数据流初始化对象。
 * void addNum(int val) 向数据流中加入整数 val 。
 * int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
 * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
 * 输出：
 * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
 * <p>
 * 解释：
 * SummaryRanges summaryRanges = new SummaryRanges();
 * summaryRanges.addNum(1);      // arr = [1]
 * summaryRanges.getIntervals(); // 返回 [[1, 1]]
 * summaryRanges.addNum(3);      // arr = [1, 3]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
 * summaryRanges.addNum(7);      // arr = [1, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
 * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
 * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= val <= 104
 * 最多调用 addNum 和 getIntervals 方法 3 * 104 次
 * <p>
 * <p>
 * 进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
 *
 * @author lvrui
 */
public class SummaryRanges2 {

    TreeSet<int[]> ts = new TreeSet<>((a, b) -> a[0] - b[0]);
    int[] head = new int[]{-10, -10}, tail = new int[]{10010, 10010};

    public SummaryRanges2() {
        ts.add(head);
        ts.add(tail);
    }

    public void addNum(int val) {
        int[] cur = new int[]{val, val};
        int[] prev = ts.floor(cur);
        int[] next = ts.ceiling(cur);
        if ((prev[0] <= val && val <= prev[1]) || (next[0] <= val && val <= next[1])) {
            // pass
        } else if (prev[1] + 1 == val && next[0] - 1 == val) {
            prev[1] = next[1];
            ts.remove(next);
        } else if (prev[1] + 1 == val) {
            prev[1] = val;
        } else if (next[0] - 1 == val) {
            next[0] = val;
        } else {
            ts.add(cur);
        }
    }

    public int[][] getIntervals() {
        // using ceiling
        // int n = ts.size();
        // int[][] ans = new int[n - 2][2];
        // int[] cur = head;
        // for (int i = 0; i < n - 2; i++) {
        //     ans[i] = ts.ceiling(new int[]{cur[0] + 1, cur[1] + 1});
        //     cur = ans[i];
        // }
        // return ans;

        // using iterator
        int n = ts.size();
        int[][] ans = new int[n - 2][2];
        Iterator<int[]> iterator = ts.iterator();
        iterator.next();
        for (int i = 0; i < n - 2; i++) ans[i] = iterator.next();
        return ans;
    }
}



