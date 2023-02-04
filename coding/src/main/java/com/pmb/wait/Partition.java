package com.pmb.wait;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class Partition {
    public static List<List<String>> partition(String s) {
        fun(s, new ArrayList<String>());
        return result;
    }

    static List<List<String>> result = new ArrayList<>();

    public static void fun(String s, List<String> one) {
        int len = s.length();
        if (len == 0) {
            result.add(new ArrayList<>(one));//这里必须新建一个。不然会覆盖
            return;
        }
        for (int i = 0; i < len; i++) {
            String tmp = s.substring(0, i + 1);
            if (isTrue(tmp)) {
                one.add(tmp);
                String rest = s.substring(i + 1, len);
                fun(rest, one);
                //回溯就在这里。这里的one已经有了一个。需要折回
                one.remove(one.size() - 1);
            }
        }
    }

    public static boolean isTrue(String s) {
        StringBuffer sb = new StringBuffer(s);
        if (sb.reverse().toString().equals(s)) return true;
        else return false;
    }


    public static void main(String[] args) {
        Partition.partition("aabbbc");
    }
}
