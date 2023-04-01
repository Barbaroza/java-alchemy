package com.pmb.code.search.binary;

import com.pmb.code.basic.prefix.Solution;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * @author lvrui
 */
public class kthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{return matrix[a[0]][a[1]]-matrix[b[0]][b[1]];});

        for(int i =0 ;i<n;i++){
            queue.offer(new int[]{0, i});
        }

        int ans = -1;
        for (int i = k; i > 0 && !queue.isEmpty(); i--) {
            int[] cur  = queue.poll();
            ans = matrix[cur[0]][cur[1]];
            if(cur[1]<n-1){
                queue.offer(new int[]{cur[0], cur[1] + 1});
            }
        }

        return  ans;
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;

    }


}
