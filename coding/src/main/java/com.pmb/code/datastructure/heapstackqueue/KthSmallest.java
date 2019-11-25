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
        int sadasd = abc.kthSmallest(a, 3);
        sadasd = 2;
    }
}
