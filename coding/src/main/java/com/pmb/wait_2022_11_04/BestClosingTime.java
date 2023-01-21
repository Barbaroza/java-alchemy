package com.pmb.wait_2022_11_04;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/biweekly-contest-92/problems/minimum-penalty-for-a-shop/
 *
 * @author lvrui
 */
public class BestClosingTime {
    private final char M = 'N';
    private final char Y = 'Y';

    public int bestClosingTime(String customers) {
        char[] chars = customers.toCharArray();
        int[] cCost = new int[chars.length];
        int[] oCost = new int[chars.length];
        Integer[] index = new Integer[chars.length + 1];
        index[chars.length] = chars.length;
        index[chars.length - 1] = chars.length - 1;
        cCost[chars.length - 1] = chars[chars.length - 1] == Y ? 1 : 0;
        oCost[0] = chars[0] == M ? 1 : 0;

        for (int j = chars.length - 2; j >= 0; j--) {
            int cnt = 0;
            if (chars[j] == Y) {
                cnt = 1;
            }
            cCost[j] = cnt + cCost[j + 1];
            index[j] = j;
        }
        for (int i = 1; i < chars.length ; i++) {
            int cnt = 0;
            if (chars[i] == M) {
                cnt = 1;
            }
            oCost[i] = cnt + oCost[i - 1];
        }
        int mCnt = oCost[chars.length - 1];
        int yCnt = chars.length - mCnt;

        Arrays.sort(index, (o1, o2) -> {

            int i = cost(o1, cCost, oCost, mCnt, yCnt) - cost(o2, cCost, oCost, mCnt, yCnt);
            return i == 0 ? o2.compareTo(o1) : i;
        });
        return index[0];
    }

    private int cost(Integer o1, int[] cCost, int[] oCost, int mCnt, int yCnt) {
        if (o1 == 0) {
            return yCnt;
        }
        if (o1 == cCost.length) {
            return mCnt;
        }
        return cCost[o1] + oCost[o1 - 1];
    }

    public static void main(String[] args) {
        BestClosingTime bestClosingTime = new BestClosingTime();
        bestClosingTime.bestClosingTime("YYNY");
    }
}
