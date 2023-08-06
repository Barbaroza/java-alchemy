package com.pmb.wait.wait_2022_05;

/**
 * https://leetcode.cn/problems/di-string-match/
 * 942. 增减字符串匹配
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 * <p>
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 * <p>
 * 输入：s = "III"
 * 输出：[0,1,2,3]
 * 示例 3：
 * <p>
 * 输入：s = "DDI"
 * 输出：[3,2,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 只包含字符 "I" 或 "D"
 *
 * @author lvrui
 */
public class DiStringMatch {
    //TODO

    private static final char D = 'D';
    private static final char I = 'I';

    public int[] diStringMatch(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[chars.length + 1];
        for (int i = 0; i < chars.length + 1; i++) {
            nums[i] = i;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == D) {
                swap(nums, i, i + 1);
                int t = i;
                while (--t >= 0 && chars[t] == D) {
                    swap(nums, t, t + 1);
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int i1) {
        int num = nums[i];
        nums[i] = nums[i1];
        nums[i1] = num;
    }

    public int[] diStringMatch2(String s) {
        int n = s.length(), lo = 0, hi = n;
        int[] perm = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            perm[i] = s.charAt(i) == 'I' ? lo++ : hi--;
        }
        perm[n] = lo; // 最后剩下一个数，此时 lo == hi
        return perm;
    }


    public static void main(String[] args) {
        DiStringMatch stringMatch = new DiStringMatch();
        stringMatch.diStringMatch("DDI");
    }
}
