package com.pmb.code2.test;

/**
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 *
 * @author Administrator
 */
public class Palindrome {
    public static boolean isPalindrome(String s) {

        boolean flag = false;
        if (s == null ) {
            return flag;
        }
        if (s.equals(""))
        {
            return true;
        }
        char[] chars = s.toCharArray();

        int head = 0;
        int tail = chars.length - 1;
        while (head <= tail) {
            while (!Character.isLetterOrDigit(chars[head]) && head < tail) {
                head++;
            }
            while (!Character.isLetterOrDigit(chars[tail]) && tail > head) {
                tail--;
            }
            if (!String.valueOf(chars[head]).equalsIgnoreCase(String.valueOf(chars[tail]))) {
                flag = false;
                break;
            } else {
                flag = true;
            }
            head++;
            tail--;

        }
        return flag;
    }


    public static void main(String[] args) {
        Palindrome.isPalindrome("");
    }

}
