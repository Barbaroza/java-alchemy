package com.pmb.code.datastructure.array;

/**
 * 718. 最长重复子数组
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (51)
 * 题解(24)
 * 提交记录
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 * <p>
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * @author lvrui
 */
public class FindLength {
    /**
     * 暴力+动态规划
     * N^3
     * NM
     *
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int res = 0;
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return res;
        }
        int aSiez = A.length, bSize = B.length;
        boolean[][] dp = new boolean[aSiez][bSize];
        for (int i = 0; i < aSiez; i++) {
            for (int n = 0; n < bSize; n++) {
                if (A[i] == B[n]) {
                    dp[i][n] = true;
                }
            }
        }
        for (int i = 0; i < aSiez; i++) {
            for (int n = 0; n < bSize; n++) {
                if (dp[i][n] && (aSiez - i) > res && (bSize - n) > res) {
                    int temp = 0;
                    int tempI = i;
                    int tempN = n;
                    while (tempI < aSiez && tempN < bSize && dp[tempI++][tempN++]) {
                        temp++;
                    }
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }

    /**
     * 逆序 DP
     * 设 dp[i][j] 为 A[i:] 和 B[j:] 的最长公共前缀，那么答案就为所有 dp[i][j] 中的最大值 max(dp[i][j])。
     * 如果 A[i] == B[j]，那么状态转移方程为 dp[i][j] = dp[i + 1][j + 1] + 1，否则状态转移方程为 dp[i][j] = 0。
     *
     * @param A
     * @param B
     * @return
     */
    public int findLength2(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindLength findLength = new FindLength();
        findLength.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
    }
}
