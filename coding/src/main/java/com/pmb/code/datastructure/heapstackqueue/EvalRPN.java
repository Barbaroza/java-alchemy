package com.pmb.code.datastructure.heapstackqueue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 * 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * @author lvrui
 */
public class EvalRPN {
    Stack<Integer> stack = new Stack<Integer>();
    Set<String> opreattion = new HashSet<String>() {
        {
            add("*");
            add("/");
            add("-");
            add("+");
        }
    };

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        for (String str : tokens) {
            if (str == null) {
                continue;
            }
            if (opreattion.contains(str)) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                if (str.equals("+")) {
                    stack.push(num1 + num2);
                } else if (str.equals("-")) {
                    stack.push(num2 - num1);
                } else if (str.equals("*")) {
                    stack.push(num1 * num2);
                } else {
                    stack.push(num2 / num1);
                }
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    private static final String ADD ="+";
    private static final String SUB ="-";
    private static final String MULTI = "*";
    private static final String DIV = "/";

    LinkedList<Integer> operands = new LinkedList();

    public int evalRPN2(String[] tokens) {
        for(int i = 0;i<tokens.length;i++){
            if(isOpreator(tokens[i])){
                int o2 = operands.removeLast();
                int o1 = operands.removeLast();
                operands.addLast(operate(tokens[i], o1,o2));
            }else{
                operands.addLast(Integer.valueOf(tokens[i]));
            }
        }

        return operands.removeLast();
    }


    private boolean isOpreator(String token){
        if(ADD.equals(token)||SUB.equals(token)||MULTI.equals(token)||DIV.equals(token)){
            return true;
        }

        return false;
    }


    private int operate(String operator,int operand1,int operand2){
        if(ADD.equals(operator)){
            return operand1 + operand2;
        }
        if(SUB.equals(operator)){
            return operand1 - operand2;
        }

        if(MULTI.equals(operator)){
            return operand1 * operand2;
        }
        if(DIV.equals(operator)){
            return operand1 / operand2;
        }
        throw new RuntimeException("invalid op:"+operator);
    }
}
