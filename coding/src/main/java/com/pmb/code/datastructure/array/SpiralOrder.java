package com.pmb.code.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：
 * [1,2,3,6,9,8,7,5,4]
 * 预期：
 * [1,2,3,6,9,8,7,4,5]
 *
 * @author lvrui
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        boolean[][] visited = new boolean[height][width];
        visit(0, 0, height, width, matrix, visited, res, 0);

        return res;
    }

    private void visit(int h, int w, int height, int width, int[][] matrix, boolean[][] visited, List<Integer> res, int actionValue) {
        if (h < 0 || h >= height || w < 0 || w >= width || visited[h][w]) {
            return;
        }
        visited[h][w] = true;
        res.add(matrix[h][w]);
        if (actionValue == 0) {
            visit(h, w + 1, height, width, matrix, visited, res, 0);
        } else if (actionValue == 1) {
            visit(h + 1, w, height, width, matrix, visited, res, 1);
        } else if (actionValue == 2) {
            visit(h, w - 1, height, width, matrix, visited, res, 2);
        } else {
            visit(h - 1, w, height, width, matrix, visited, res, 3);
        }

        visit(h, w + 1, height, width, matrix, visited, res, 0);
        visit(h + 1, w, height, width, matrix, visited, res, 1);
        visit(h, w - 1, height, width, matrix, visited, res, 2);
        visit(h - 1, w, height, width, matrix, visited, res, 3);
    }

    /**
     * [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
     * [1,2,3,4,8,12,16,15,14,13,9,10,11,7,6,5]
     * 预期：
     * [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
     *
     * @param args
     */
    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        spiralOrder.spiralOrder(new int[][]{new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16}});
    }
}
