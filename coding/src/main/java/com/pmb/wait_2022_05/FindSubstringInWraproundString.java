package com.pmb.wait_2022_05;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 *
 * @author lvrui
 * 把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的：
 * <p>
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." . 
 * 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。 
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: p = "a"
 * 输出: 1
 * 解释: 字符串 s 中只有一个"a"子字符。
 * 示例 2:
 * <p>
 * 输入: p = "cac"
 * 输出: 2
 * 解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
 * 示例 3:
 * <p>
 * 输入: p = "zab"
 * 输出: 6
 * 解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= p.length <= 105
 * p 由小写英文字母构成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/unique-substrings-in-wraparound-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSubstringInWraproundString {
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.equals("")) {
            return 0;
        }


        //abc   1+ 1 * 1 + 1
        int[] dp = new int[26];

        char[] chars = p.toCharArray();

        int k = 1;
        dp[chars[0] - 'a'] = k;
        for (int i = 1; i < chars.length; i++) {

            int d = chars[i] - chars[i - 1];
            if (d == 1 || d == -25) {
                k++;
            } else {
                k = 1;
            }
            dp[chars[i] - 'a'] = Math.max(dp[chars[i] - 'a'], k);
        }

        return Arrays.stream(dp).sum();
    }


    public static void main(String[] args) {

        FindSubstringInWraproundString findSubstringInWraproundString = new FindSubstringInWraproundString();

        int substringInWraproundString = findSubstringInWraproundString.findSubstringInWraproundString("zab");

    }

}
