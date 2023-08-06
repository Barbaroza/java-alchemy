package com.pmb.wait.wait_2023_01_02;

/**
 * https://leetcode.cn/contest/weekly-contest-329/problems/apply-bitwise-operations-to-make-strings-equal/
 * 0 | 1 = 1
 * 1| 0 = 1
 * 0 | 0 = 0
 * 1| 1 = 1
 * <p>
 * 0 ^ 1 = 1
 * 1 ^ 0 = 1
 * 0 ^ 0 = 0
 * 1 ^ 1 = 0
 * <p>
 * 0-1 1-0 -> 1-1
 * 1-1 -> 1-0 0-1
 *
 * @author lvrui
 */
public class MakeStringsEqual {
    public boolean makeStringsEqual(String s, String target) {
        char[] chars = s.toCharArray();
        int oneSCnt = 0;
        int zeroSCnt = 0;
        for (char c : chars) {
            if (c == '0') {
                zeroSCnt++;
            } else {
                oneSCnt++;
            }
        }

        char[] tChars = target.toCharArray();
        int oneTCnt = 0;
        int zerTSCnt = 0;

        for (char c : tChars) {
            if (c == '0') {
                zerTSCnt++;
            } else {
                oneTCnt++;
            }
        }
        if (oneSCnt == oneTCnt) {
            return true;
        }
        if (oneSCnt / 2 > oneTCnt) {
            return false;
        }
        if (zeroSCnt == 0) {
            return false;
        }

        if (zeroSCnt > zerTSCnt && oneTCnt == 0) {
            return false;

        }
        return true;
    }
}
