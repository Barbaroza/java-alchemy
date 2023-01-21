package com.pmb.code.datastructure.array;

/**
 * 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * 解释:
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 给定矩阵中的元素总数不会超过 100000 。
 *
 * @author lvrui
 */
public class FindDiagonalOrder {
    private boolean flag = true;

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int length = matrix.length;
        int width = matrix[0].length;
        int[] res = new int[length * width];

        int index = 0, i = 0, j = 0;
        while (index < length * width) {
            res[index] = matrix[i][j];

            if (flag) {
                if (i - 1 >= 0 && j + 1 < width) {
                    i--;
                    j++;
                } else {
                    if (j + 1 < width) {
                        j++;
                    } else if (i + 1 < length) {
                        i++;
                    }
                    flag = !flag;

                }
            } else {
                if (i + 1 < length && j - 1 >= 0) {
                    i++;
                    j--;

                } else {
                    if (i + 1 < length) {
                        i++;
                    } else if (j + 1 < width) {
                        j++;
                    }
                    flag = !flag;

                }
            }
            index++;
        }
        return res;
    }
}
