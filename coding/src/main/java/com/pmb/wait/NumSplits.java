package com.pmb.wait;

/**
 * 1525. 字符串的好分割数目
 * 给你一个字符串 s ，一个分割被称为 「好分割」 当它满足：将 s 分割成 2 个字符串 p 和 q ，它们连接起来等于 s 且 p 和 q 中不同字符的数目相同。
 * <p>
 * 请你返回 s 中好分割的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aacaba"
 * 输出：2
 * 解释：总共有 5 种分割字符串 "aacaba" 的方法，其中 2 种是好分割。
 * ("a", "acaba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
 * ("aa", "caba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
 * ("aac", "aba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
 * ("aaca", "ba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
 * ("aacab", "a") 左边字符串和右边字符串分别包含 3 个和 1 个不同的字符。
 * 示例 2：
 * <p>
 * 输入：s = "abcd"
 * 输出：1
 * 解释：好分割为将字符串分割成 ("ab", "cd") 。
 * 示例 3：
 * <p>
 * 输入：s = "aaaaa"
 * 输出：4
 * 解释：所有分割都是好分割。
 * 示例 4：
 * <p>
 * 输入：s = "acbadbaada"
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * s 只包含小写英文字母。
 * 1 <= s.length <= 10^5
 *
 * @author lvrui
 */
public class NumSplits {

    public int numSplits(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] l2r = new int[chars.length];
        int[] r2l = new int[chars.length];

        int[] l2rCount = new int[26];
        int[] r2lCount = new int[26];
        l2r[0] = 1;
        r2l[chars.length - 1] = 1;
        for (int index = 1; index < chars.length; index++) {
            int current = l2rCount[chars[index] - 'a'];
            if (current != 0) {
                l2r[index] = l2r[index - 1] + 1;
                l2rCount[chars[index] - 'a'] = 1;
            }
        }

        for (int index = chars.length - 2; index >= 0; index--) {
            int current = r2lCount[chars[index] - 'a'];
            if (current != 0) {
                l2r[index] = l2r[index + 1] + 1;
                r2lCount[chars[index] - 'a'] = 1;
            }
        }
        int res = 0;
        for (int index = 1; index < chars.length - 1; index++) {
            if (l2r[index - 1] == r2l[index]) {
                res++;
            }
        }

        return res;
    }
}
