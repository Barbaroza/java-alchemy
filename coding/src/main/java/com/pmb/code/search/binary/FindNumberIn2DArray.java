package com.pmb.code.search.binary;

/**
 * https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-b-3/
 *
 * @author lvrui
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix ==null || matrix.length == 0
                || matrix[0] == null || matrix[0].length ==0){
            return false;

        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        if (matrix[0][0] > target || matrix[m][n] < target) {
            return false;
        }
        int x = m, y = 0;

        while (x >= 0 && y <= n) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }

        return false;
    }

}
