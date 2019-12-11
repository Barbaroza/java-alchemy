package com.pmb.code.datastructure.heapstackqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 * <p>
 * 示例:
 * <p>
 * matrix = [
 * [ 1,  3,  5],
 * [1, 6, 7],
 * [11, 14, 14]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 * 说明:
 * 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 *
 * @author lvrui
 */
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int matrixHight = matrix.length;
        int width = matrix[0].length;
        int kV = k;
        for (int i = 0; i < matrixHight; i++) {
            int current = (matrixHight + width - 2 * i - 1);
            if (current >= kV) {
                int x = i;
                int y = i;
                List<Integer> temp = new ArrayList<>(current);
                for (int xIndex = x; xIndex < width; xIndex++) {
                    temp.add(matrix[y][xIndex]);
                }
                for (int yIndex = y + 1; yIndex < matrixHight; yIndex++) {
                    temp.add(matrix[yIndex][x]);
                }
                Collections.sort(temp);
                return temp.get(kV - 1);
            } else {
                kV = kV - current;
            }
        }
        return 0;
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];
        while (left < right) {
            // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
            int mid = (left + right) / 2;
            // 找二维矩阵中<=mid的元素总个数
            int count = findNotBiggerThanMid(matrix, mid, row, col);
            if (count < k) {
                // 第k小的数在右半部分，且不包含mid
                left = mid + 1;
            } else {
                // 第k小的数在左半部分，可能包含mid
                right = mid;
            }
        }
        return right;
    }

    private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                // 第j列有i+1个元素<=mid
                count += i + 1;
                j++;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }

    public int kthSmallest3(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if (count < k)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }


    /**
     * [[1,5,9],[10,11,13],[12,13,15]]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] a = new int[3][3];
        a[0] = new int[]{1, 3, 5};
        a[1] = new int[]{1, 6, 7};
        a[2] = new int[]{11, 14, 14};

        KthSmallest abc = new KthSmallest();
        int sadasd = abc.kthSmallest2(a, 3);
        sadasd = 2;
    }
}
