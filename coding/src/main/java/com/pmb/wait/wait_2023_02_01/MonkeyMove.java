package com.pmb.wait.wait_2023_02_01;

/**
 * https://leetcode.cn/contest/weekly-contest-330/problems/count-collisions-of-monkeys-on-a-polygon/
 *
 * @author lvrui
 */
public class MonkeyMove {

    public int monkeyMove(int n) {
        int mod = (int) 1e9 + 7;
        int tmp = qmi(2, n, mod);
        return (tmp + mod - 2) % mod;
    }

    static int qmi(long a, int b, int p) {
        long ans = 1;
        a = (a % p + p) % p;
        for (; b > 0; b >>= 1) {
            if ((b & 1) != 0) ans = (a * ans) % p;
            a = (a * a) % p;
        }
        return (int) ans;
    }


    public static void main(String[] args) {
        MonkeyMove monkeyMove = new MonkeyMove();
        monkeyMove.monkeyMove(3);

        qmi(2, 7, 1000000007);
    }
}
