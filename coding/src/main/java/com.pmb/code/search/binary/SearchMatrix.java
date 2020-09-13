package com.pmb.code.search.binary;

/**
 * 74 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 通过次数61,046提交次数15
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int length = matrix.length;
        int width = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[length - 1][width - 1]) {
            return false;
        }
        int left = length * width - 1;
        int right = 0;

        while (right <= left) {
            int middle = (left + right) >> 1;
            int value = matrix[middle / width][middle % width];
            if (value < target) {
                right = middle + 1;
            } else if (value == target) {
                return true;
            } else {
                left = middle - 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        int[][] a = new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 18, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        //[[1,3,5,7],[10,11,16,20],[23,30,34,50]]
        //3
        int[][] b = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        SearchMatrix searchMatrix = new SearchMatrix();
        searchMatrix.searchMatrix(b, 3);

    }

}

