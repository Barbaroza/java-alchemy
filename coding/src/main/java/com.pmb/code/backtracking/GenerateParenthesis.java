package com.pmb.code.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author lvrui
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = null;
        if (n > 0) {
            res = new ArrayList<String>();
            bt(res, "", 0, 0, n);
        }

        return res;
    }

    private void bt(List<String> res, String s, int left, int right, int n) {
        if (right > left) {
            return;
        }
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }
        if (left < n) {
            bt(res, s + "(", ++left, right, n);
        }
        if (right <= left) {
            bt(res, s + (")"), left, ++right, n);
        }
    }
}
