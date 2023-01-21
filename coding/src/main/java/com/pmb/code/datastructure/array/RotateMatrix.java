package com.pmb.code.datastructure.array;

/**
 * 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * 00->03->33->30
 * 01->13->32->20
 * 11->12->22->21
 *
 * @author lvrui
 */
public class RotateMatrix {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 1) {
            return;
        }
        int time = matrix.length - 1 >> 1;

        for (int i = 0; i <= time; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                int a = j;
                int b = matrix.length - 1 - i;
                int value = matrix[i][j];
                int count = 0;
                while (count < 4) {
                    int temp = matrix[a][b];
                    matrix[a][b] = value;
                    value = temp;
                    int tempindx = a;
                    a = b;
                    b = matrix.length - 1 - tempindx;
                    count++;
                }
            }
        }


    }

    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        rotateMatrix.rotate(new int[][]{new int[]{1, 2}, new int[]{3, 4}});

    }
}
