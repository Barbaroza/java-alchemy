package com.pmb.wait;

/**
 * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26F，字符'*'可以被当做1到9当中的任意一个数字。
 * <p>
 * 给定一条包含数字和字符'*'的加密信息，请确定解码方法的总数。
 * <p>
 * 同时，由于结果值可能会相当的大，所以你应当对109 + 7取模。（翻译者标注：此处取模主要是为了防止溢出）
 * <p>
 * 示例 1 :
 * <p>
 * 输入: "*"
 * 输出: 9
 * 解释: 加密的信息可以被解密为: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 * 示例 2 :
 * <p>
 * 输入: "1*"
 * 输出: 9 + 9 = 18（翻译者标注：这里1*可以分解为1,* 或者当做1*来处理，所以结果是9+9=18）
 * 说明 :
 * <p>
 * 输入的字符串长度范围是 [1, 105]。
 * 输入的字符串只会包含字符 '*' 和 数字'0' - '9'。
 *
 * @author Administrator
 */
public class NumDecodings {
    public static int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = s.length();
        int[] res = new int[length];
        if (chars[length - 1] != '0') {
            if (chars[length - 1] != '*') {
                res[length - 1] = 1;
            } else {
                res[length - 1] = 9;
            }
        }

        for (int i = length - 2; i >= 0; i--) {
            if (chars[i] == '0') {
                continue;
            }
            char nextNum = chars[i + 1];
            char currentNum = chars[i];
            if (currentNum != '*') {
                if (currentNum == '1' || currentNum == '2') {

                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        NumDecodings.numDecodings("01");
    }
}
