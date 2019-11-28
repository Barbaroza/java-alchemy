package com.pmb.code.backtracking;

/**
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * @author lvrui
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.isEmpty()) {
            return false;
        }
        char[] chars = word.toCharArray();
        int width = board.length;
        int length = board[0].length;
        int[][] attached = new int[width][length];

        for (int rowIndex = 0; rowIndex < width; rowIndex++) {
            for (int lengthIndex = 0; lengthIndex < length; lengthIndex++) {
                if (isWay(board, rowIndex, lengthIndex, attached, width, length, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWay(char[][] board, int rowIndex, int lengthIndex, int[][] attached, int width, int length, char[] chars, int i) {
        if (chars.length == i) {
            return true;
        }
        if (rowIndex < 0 || rowIndex >= width || lengthIndex < 0 || lengthIndex >= length) {
            return false;
        }
        if (chars[i] != board[rowIndex][lengthIndex]) {
            return false;
        }
        if (attached[rowIndex][lengthIndex] == 1) {
            return false;
        }
        attached[rowIndex][lengthIndex] = 1;
        boolean a = isWay(board, rowIndex - 1, lengthIndex, attached, width, length, chars, i + 1);
        boolean b = isWay(board, rowIndex + 1, lengthIndex, attached, width, length, chars, i + 1);
        boolean c = isWay(board, rowIndex, lengthIndex - 1, attached, width, length, chars, i + 1);
        boolean d = isWay(board, rowIndex, lengthIndex + 1, attached, width, length, chars, i + 1);
        if (a | b | c | d) {
            return true;
        }
        attached[rowIndex][lengthIndex] = 0;
        return false;
    }
}
