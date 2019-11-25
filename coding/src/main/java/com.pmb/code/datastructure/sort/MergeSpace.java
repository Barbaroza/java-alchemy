package com.pmb.code.datastructure.sort;

import java.util.Arrays;

/**
 * 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author lvrui
 */
public class MergeSpace {
    public int[][] merge(int[][] intervals) {
        int[][] res = new int[][]{};
        if (intervals == null || intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        merge(intervals, 0, intervals.length - 1);

        int last = intervals[0][1];
        for (int index = 1; index < intervals.length; index++) {
            int prefix = intervals[index][0];
            int suffix = intervals[index][1];

        }
        return res;
    }

    private void merge(int[][] intervals, int start, int end) {
        if (start <= end) {
            return;
        }
        int mid = (start + end) / 2;
        merge(intervals, start, mid);
        merge(intervals, mid + 1, end);
        merge(intervals, start, mid, end);
    }

    private void merge(int[][] intervals, int start, int mid, int end) {
        int left = start;
        int middle = mid + 1;
        int[][] temp = Arrays.copyOfRange(intervals, start, end);
        for (int i = start; i <= end; i++) {
            if (left > mid) {
                intervals[i] = temp[middle - start];
                middle++;
            } else if (middle > end) {
                intervals[i] = temp[left - start];
                left++;
            } else if (temp[middle - start][0] > temp[left - start][0]) {
                intervals[i] = temp[left - start];
                left++;
            } else {
                intervals[i] = temp[middle - start];
                middle++;
            }
        }

    }
}
