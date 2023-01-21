package com.pmb.code.datastructure.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        if (intervals == null || intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        merge(intervals, 0, intervals.length - 1);
        Map<Integer, Integer> temp = new HashMap<>();
        int lastStart = intervals[0][0];
        int lastEnd = intervals[0][1];
        temp.put(lastStart, lastEnd);

        for (int index = 1; index < intervals.length; index++) {
            int prefix = intervals[index][0];
            int suffix = intervals[index][1];
            if (prefix <= lastEnd) {
                int max = Math.max(lastEnd, suffix);
                temp.put(lastStart, max);
                lastEnd = max;
            } else {
                temp.put(prefix, suffix);
                lastStart = prefix;
                lastEnd = suffix;
            }
        }
        int[][] res = new int[temp.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
            res[index][0] = entry.getKey();
            res[index++][1] = entry.getValue();
        }
        return res;
    }

    private void merge(int[][] intervals, int start, int end) {
        if (start >= end) {
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
        int index = start;
        int[][] temp = Arrays.copyOfRange(intervals, start, end + 1);
        while (left <= mid && middle <= end) {
            if (temp[left - start][0] < temp[middle - start][0]) {
                intervals[index++] = temp[left - start];
                left++;
            } else if (temp[left - start][0] == temp[middle - start][0]) {
                if (temp[left - start][1] < temp[middle - start][1]) {
                    intervals[index++] = temp[left - start];
                    left++;
                } else {
                    intervals[index++] = temp[middle - start];
                    middle++;
                }
            } else {
                intervals[index++] = temp[middle - start];
                middle++;
            }
        }
        while (left <= mid) {
            intervals[index++] = temp[left - start];
            left++;
        }
        while (middle <= end) {
            intervals[index++] = temp[middle - start];
            middle++;
        }
    }


    /**
     * [[1,3],[2,6],[8,10],[15,18]]
     *
     * @param args
     */
    public static void main(String[] args) {
        MergeSpace mergeSpace = new MergeSpace();
        mergeSpace.merge(new int[][]{new int[]{1, 3}
                , new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}}
        );
    }

}
