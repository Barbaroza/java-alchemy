package com.pmb.code.bitwise;

/**
 * https://leetcode.cn/problems/JFETK5/
 * @author lvrui
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int intA = Integer.parseInt(a, 2);
        int intB = Integer.parseInt(b, 2);

        while (intB > 0) {
            int carry = (intA & intB) << 1;
            intA = intA ^ intB;
            intB = carry;
        }

        return Integer.toBinaryString(intA);

    }
}
