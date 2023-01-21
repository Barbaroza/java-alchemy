package com.pmb.code.datastructure.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * @author lvrui
 */
public class RestoreIpAddresses {
    private int minLength = 4;
    private int maxLength = 12;

    /**
     * dfs + 约束
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        getRes(res, s, 0, 0, "");
        return res;
    }

    private void getRes(List<String> res, String s, int index, int count, String temp) {
        for (int i = index + 1; i <= index + 3 && i <= s.length(); i++) {
            String substring = s.substring(index, i);
            if ((substring.startsWith("0") && !substring.equals("0")) || Integer.valueOf(substring) > 255) {
                continue;
            }
            if (count < 3) {
                getRes(res, s, i, count + 1, temp + substring + ".");
            } else {
                if (i == s.length()) {
                    res.add(temp + substring);
                }
            }
        }
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> strings = restoreIpAddresses.restoreIpAddresses("0000");
    }
}
