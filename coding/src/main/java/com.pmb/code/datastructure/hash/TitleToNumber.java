package com.pmb.code.datastructure.hash;

/**
 * @author lvrui
 */
public class TitleToNumber {
    public int titleToNumber(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        int res = 0;
        for (int i = 0; i < length; i++) {

            int value = (int) (Character.toLowerCase(chars[i]) - 'a') + 1;
            res = (int) (res + value * Math.pow(26, length - i - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        TitleToNumber titleToNumber = new TitleToNumber();
        titleToNumber.titleToNumber("A");
    }
}
