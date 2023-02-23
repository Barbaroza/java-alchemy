package com.pmb.code.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvrui
 */
public class SpiralOrder2 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }

        List<Integer> ans = new ArrayList(matrix.length * matrix[0].length);
        int[][] path = new int[matrix.length][matrix[0].length];

        fill(ans, matrix, 0, 0, path);

        int[] arrAns = new int[ans.size()];
        for(int i = 0;i<ans.size();i++){
            arrAns[i] = ans.get(i);
        }
        return  arrAns;
    }


    private void fill(List<Integer> ans, int[][] matrix, int i, int j, int[][] path) {
        if (i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length - 1 || path[i][j] != 0) {
            return;
        }
        path[i][j] = 1;
        ans.add(matrix[i][j]);

        fill(ans, matrix, i, j + 1, path);
        fill(ans, matrix, i + 1, j, path);
        fill(ans, matrix, i, j - 1, path);
        fill(ans, matrix, i - 1, j, path);

    }
}
