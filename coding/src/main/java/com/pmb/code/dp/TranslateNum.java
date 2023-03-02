package com.pmb.code.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/submissions/
 *
 * @author lvrui
 */
public class TranslateNum {

    public int translateNum(int num) {
        if (num <= 10) {
            return 1;
        } else if (num <= 25) {
            return 2;
        } else if (num <= 99) {
            return 1;
        } else {
            List<Integer> bits = new ArrayList<Integer>();
            while (num != 0) {
                bits.add(num % 10);
                num /= 10;
            }
            Collections.reverse(bits);
            int[] dp = new int[bits.size()];
            dp[0] = 1;
            dp[1] = value(bits.get(0), bits.get(1));
            for (int i = 2; i < bits.size(); i++) {
                dp[i] = value(bits.get(i - 1), bits.get(i)) == 1 ? dp[i-1] : dp[i - 2] + dp[i - 1];
            }


            return dp[bits.size() - 1];

        }
    }

    private int value(Integer a, Integer b) {
        int num = 10 * a + b;

        if (num < 10) {
            return 1;
        } else if (num > 25) {
            return 1;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        translateNum.translateNum(1068385902);
    }
}
