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

    private static final String S_L ="(";
    private static final String S_R = ")";
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        StringBuilder path = new StringBuilder();
        dfs(path,n,n,n,ans);

        return ans;
    }


    private void dfs(StringBuilder path, final int n,int leftRem,int rightRem,List<String> ans){
        if(path.length() == n*2){
            ans.add(path.toString());
            return;
        }
        if(leftRem>0){
            path.append(S_L);
            dfs(path,n,leftRem-1,rightRem,ans);
            path.delete(path.length()-1,path.length());
        }
        if(leftRem < rightRem && rightRem>0){
            path.append(S_R);
            dfs(path,n,leftRem,rightRem-1,ans);
            path.delete(path.length()-1,path.length());
        }



    }
}
