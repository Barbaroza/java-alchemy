package com.pmb.wait;

import java.util.ArrayList;
import java.util.List;

/**
 * 1415. 长度为 n 的开心字符串中字典序第 k 小的字符串
 * @star
 * 一个 「开心字符串」定义为：
 * <p>
 * 仅包含小写字母 ['a', 'b', 'c'].
 * 对所有在 1 到 s.length - 1 之间的 i ，满足 s[i] != s[i + 1] （字符串的下标从 1 开始）。
 * 比方说，字符串 "abc"，"ac"，"b" 和 "abcbabcbcb" 都是开心字符串，但是 "aa"，"baa" 和 "ababbc" 都不是开心字符串。
 * <p>
 * 给你两个整数 n 和 k ，你需要将长度为 n 的所有开心字符串按字典序排序。
 * <p>
 * 请你返回排序后的第 k 个开心字符串，如果长度为 n 的开心字符串少于 k 个，那么请你返回 空字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1, k = 3
 * 输出："c"
 * 解释：列表 ["a", "b", "c"] 包含了所有长度为 1 的开心字符串。按照字典序排序后第三个字符串为 "c" 。
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 4
 * 输出：""
 * 解释：长度为 1 的开心字符串只有 3 个。
 * 示例 3：
 * <p>
 * 输入：n = 3, k = 9
 * 输出："cab"
 * 解释：长度为 3 的开心字符串总共有 12 个 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"] 。第 9 个字符串为 "cab"
 * 示例 4：
 * <p>
 * 输入：n = 2, k = 7
 * 输出：""
 * 示例 5：
 * <p>
 * 输入：n = 10, k = 100
 * 输出："abacbabacb"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10
 * 1 <= k <= 100
 *
 * @author lvrui
 */
public class GetHappyString {
    public String getHappyString(int n, int k) {
        char[] chars = new char[]{'a', 'b', 'c'};
        int max = 3 * (int) Math.pow(2, n - 1);
        if (k > max) {
            return "";
        }


        StringBuilder sb = new StringBuilder();
        int sharding = (k - 1) / (max / 3);
        sb.append(chars[sharding]);
        max = max / 3;
        k = k - 1 - sharding * max;

        for (int i = 1; i < n; i++) {
            max /= 2;
            char c = sb.charAt(sb.length() - 1);
            if (k / max == 1) {
                sb.append(c == chars[0] ? chars[2] : c == chars[1] ? chars[2] : chars[1]);
                k = k - max;
            } else {
                sb.append(c == chars[0] ? chars[1] : chars[0]);
            }
        }

        return sb.toString();
    }



    public static void main(String[] args) {
        GetHappyString getHappyString = new GetHappyString();
        getHappyString.getHappyString(7, 8);
    }
}
