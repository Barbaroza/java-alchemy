package com.pmb.wait_2022_12_02;

/**
 * https://leetcode.cn/contest/biweekly-contest-93/problems/frog-jump-ii/
 *
 * @author lvrui
 */
public class MaxJump {
    public int maxJump(int[] stones) {
        int n = stones.length;
        if (n == 2) {
            return stones[1] - stones[0];
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (i >= 2) {
                if (stones[i] - stones[i - 2] > ret) {
                    ret = stones[i] - stones[i - 2];
                }
            }
        }
        return ret;
    }
}
