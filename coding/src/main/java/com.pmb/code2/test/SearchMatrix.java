package com.pmb.code2.test;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 *
 * @author Administrator
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int length = matrix.length;
        int width = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[length - 1][width - 1]) {
            return false;
        }
        return exist(0, 0, length - 1, width - 1, matrix, target);
    }

    private static boolean exist(int startX, int startY, int endX, int endY, int[][] matrix, int target) {
        if (startX + 1 >= endX && startY + 1 >= endY) {
            if (matrix[startX][startY] == target) {
                return true;
            }
            if (matrix[endX][endY] == target) {
                return true;
            }
            if (startX + 1 < matrix.length) {
                if (matrix[startX + 1][startY] == target) {
                    return true;
                }
            }
            if (startY + 1 < matrix[0].length) {
                if (matrix[startX][startY + 1] == target) {
                    return true;
                }
            }
            return false;
        }
        int j = (startX + endX) / 2;
        int i = (startY + endY) / 2;

        if (matrix[j][i] < target) {
            return exist(j, i, endX, endY, matrix, target);
        }
        if (matrix[j][i] > target) {
            return exist(startX, startY, j, i, matrix, target);
        }
        if (matrix[j][i] == target) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        System.out.println(SearchMatrix.searchMatrix(a, 15));
    }

}

