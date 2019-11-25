package com.pmb.code2.test;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * @author Administrator
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {

        if (x < 0  || x % 10 == 0) {
            return false;
        }
        int reverted = 0;
        while (x > reverted) {
            reverted = reverted * 10 + x % 10;
            x /= 10;
        }
        return x == reverted || x == reverted/10;
    }
}
