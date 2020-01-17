package com.pmb.code.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @author lvrui
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        if (n == 0) {
            return res;
        }
        visit(0, 0, n, n, res, visited, 1, 0);
        return res;
    }

    private void visit(int h, int w, int height, int width, int[][] matrix, boolean[][] visited, int index, int actionValue) {
        if (h < 0 || h >= height || w < 0 || w >= width || visited[h][w]) {
            return;
        }
        visited[h][w] = true;
        matrix[h][w] = index;
        if (actionValue == 0) {
            visit(h, w + 1, height, width, matrix, visited, index + 1, 0);
        } else if (actionValue == 1) {
            visit(h + 1, w, height, width, matrix, visited, index + 1, 1);
        } else if (actionValue == 2) {
            visit(h, w - 1, height, width, matrix, visited, index + 1, 2);
        } else {
            visit(h - 1, w, height, width, matrix, visited, index + 1, 3);
        }

        visit(h, w + 1, height, width, matrix, visited, index + 1, 0);
        visit(h + 1, w, height, width, matrix, visited, index + 1, 1);
        visit(h, w - 1, height, width, matrix, visited, index + 1, 2);
        visit(h - 1, w, height, width, matrix, visited, index + 1, 3);
    }
}
