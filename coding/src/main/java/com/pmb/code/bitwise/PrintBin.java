package com.pmb.code.bitwise;

/**
 * https://leetcode.cn/problems/bianry-number-to-string-lcci/
 * @author lvrui
 */
public class PrintBin {
    public String printBin(double num) {
        StringBuilder ans = new StringBuilder("0.");
        while (ans.length() < 32 && num != 0) {
            num *= 2;
            int x = (int) num;
            ans.append(x);
            num -= x;
        }
        return num != 0 ? "ERROR" : ans.toString();
    }

}
