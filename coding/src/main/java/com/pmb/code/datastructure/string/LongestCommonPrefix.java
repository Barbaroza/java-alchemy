package com.pmb.code.datastructure.string;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author lvrui
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs != null && strs.length > 0) {
            boolean flag = true;
            int index = 0;
            while (flag) {
                char current = '1';
                for (String str : strs) {
                    if (index >= str.length()) {
                        flag = false;
                        break;
                    }
                    if (current == '1') {
                        current = str.charAt(index);
                    }
                    if (current != '1' && current != str.charAt(index)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    sb.append(current);
                }
                index++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
    }
}
