package com.pmb.wait.wait_2022_01_04;

/**
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
 *
 * @author lvrui
 * 1614. 括号的最大嵌套深度
 * 如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：
 * <p>
 * 字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。
 * 字符串可以写为 AB（A 与 B 字符串连接），其中 A 和 B 都是 有效括号字符串 。
 * 字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。
 * 类似地，可以定义任何有效括号字符串 S 的 嵌套深度 depth(S)：
 * <p>
 * depth("") = 0
 * depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")"
 * depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
 * depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串
 * 例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
 * <p>
 * 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(1+(2*3)+((8)/4))+1"
 * 输出：3
 * 解释：数字 8 在嵌套的 3 层括号中。
 * 示例 2：
 * <p>
 * 输入：s = "(1)+((2))+(((3)))"
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "1+(2*3)/(2-1)"
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：s = "1"
 * 输出：0
 */
public class MaxDepth {

    private static final Character LEFT_SE = '(';
    private static final Character RIGHT_SE = ')';

    public int maxDepth(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int stack = 0;
        int max = 0;

        for (char c : s.toCharArray()) {
            if (LEFT_SE.equals(c)) {
                stack++;
                max = Math.max(max, stack);
            }
            if (RIGHT_SE.equals(c)) {
                if (stack > 0) {
                    stack--;
                }else {
                    max = 0;
                    break;
                }
            }
        }
        if (stack > 0) {
            max = 0;
        }

        return max;
    }
}
