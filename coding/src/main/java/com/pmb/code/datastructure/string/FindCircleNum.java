package com.pmb.code.datastructure.string;

/**
 * 朋友圈
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 示例 2:
 * <p>
 * 输入:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 注意：
 * <p>
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 *
 * @author lvrui
 */
public class FindCircleNum {

    public int findCircleNum(int[][] M) {
        int res = 0;
        int[] view = new int[M.length];
        for (int index = 0; index < M.length; index++) {
            if (M[index][index] == 1) {
                res++;
                dfs(M, index);
            }
        }
        return res;
    }

    private void dfs(int[][] m, int index) {
        if (m[index][index] == 0) {
            return;
        }
        m[index][index] = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[index][i] == 1) {
                m[i][index] = 0;
                m[index][i] = 0;
                dfs(m, i);
            }
        }
    }

    public static void main(String[] args) {
        FindCircleNum findCircleNum = new FindCircleNum();
        findCircleNum.findCircleNum(new int[][]{new int[]{1, 0, 0, 1},
                new int[]{0, 1, 1, 0},
                new int[]{0, 1, 1, 1},
                new int[]{1, 0, 1, 1}});

    }
}
