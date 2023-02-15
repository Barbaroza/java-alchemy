package com.pmb.wait_2023_02_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author lvrui
 */
public class StrSolution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder ans = new StringBuilder();

        if (strs == null || strs.length == 0) {
            return ans.toString();
        }

        int minLength = Arrays.stream(strs).map(String::length).min(Integer::compareTo).get();


        for (int i = 0; i < minLength; i++) {
            char headChar = strs[0].charAt(i);
            boolean isSame = true;
            for (int j = 1; j < strs.length; j++) {
                isSame = strs[j].charAt(i) == headChar;
            }
            if (!isSame) {
                break;
            }
            ans.append(headChar);

        }


        // write code here

        return ans.toString();
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> ans = new ArrayList<Interval>();


        if (intervals == null || intervals.isEmpty()) {
            return ans;
        }

        Collections.sort(intervals,
                (a, b) -> {
                    int headC = a.start - b.start;
                    return headC == 0 ? a.end - (b.end) : headC;
                }
        );


        int preT = intervals.get(0).end;
        ans.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (preT < cur.end) {

                if (cur.start <= preT) {
                    ans.get(ans.size() - 1).end = cur.end;
                    preT = cur.end;

                } else {
                    ans.add(cur);
                    preT = cur.end;

                }
            }

        }


        return ans;
    }

    public String minWindow(String S, String T) {

        if (S == null || S.length() == 0)//特殊情况，返回空字符串
            return "";
        if (T == null || T.length() == 0)
            return "";
        int[] td = new int[256];//设置td，保存T中所有字符出现的次数
        for (char tc : T.toCharArray())//字符串转换为字符数组
            td[tc]++;
        int[] sd = new int[256];
        int slen = S.length();
        int start = 0, first = -1, end = 0;//距离标志
        int found = 0;//在S中发现T元素的数目
        for (int i = 0; i < S.length(); i++) {
            sd[S.charAt(i)]++;//charAt(i)为第i个字符在字符串S中所占的位置
            if (sd[S.charAt(i)] <= td[S.charAt(i)]) {//计算S的位置是否与T的位置相等
                found++;
            }
            if (found == T.length()) {//满足条件
                while (start <= i && sd[S.charAt(start)] > td[S.charAt(start)]) {
                    sd[S.charAt(start)]--;
                    start++;
                }
                //如果比当前最小子串小，则更新
                if (i + 1 - start <= slen) {
                    slen = i + 1 - start;
                    first = start;
                    end = i + 1;
                }
                sd[S.charAt(start)]--;
                start++;
                found--;
            }
        }
        if (first == -1) {
            return "";
        } else {
            return S.substring(first, end);//返回最终子串的范围
        }
    }

    public int maxLength(int[] arr) {

        int ans = 0;
        int l = 0;
        int r = 0;
        int[] unique = new int[100001];
        for (int i = 0; i < arr.length; i++) {
            unique[arr[i]]++;

            while (l <= i && unique[arr[i]] > 1) {
                unique[arr[l]]--;
                l++;
            }
            ans = Math.max(i - l + 1, ans);


        }

        return Math.max(r - l + 1, ans);
        // write code here
    }

    public static void main(String[] args) {
        StrSolution strSolution = new StrSolution();

        strSolution.maxLength(new int[]{3, 3, 2, 1, 3, 3, 3, 1});
    }
}
