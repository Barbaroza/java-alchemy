package com.pmb.code.datastructure.heapstackqueue;

import java.util.Stack;

/**
 * 基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * @author lvrui
 */
public class Calculate {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        if (s == null || s.length() == 0) {
            return 0;
        }
        char operate = '+';
        char[] chars = s.toCharArray();
        int currentNum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                int temp = chars[i] - '0';
                currentNum = currentNum * 10 + temp;
            } else {
                if (chars[i] == '+' || chars[i] == '/' || chars[i] == '*' || chars[i] == '-') {
                    if (operate == '+') {
                        stack.push(currentNum);
                    } else if (operate == '-') {
                        stack.push(-currentNum);
                    } else if (operate == '*') {
                        stack.push(stack.pop() * currentNum);
                    } else {
                        stack.push(stack.pop() / currentNum);
                    }
                    operate = chars[i];
                    currentNum = 0;
                }
            }
        }
        if (operate == '+') {
            stack.push(currentNum);
        } else if (operate == '-') {
            stack.push(-currentNum);
        } else if (operate == '*') {
            stack.push(stack.pop() * currentNum);
        } else {
            stack.push(stack.pop() / currentNum);
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }


    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        calculate.calculate("10/10 ");
    }
}
