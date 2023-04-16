package com.pmb.code.bitwise;

/**
 * @author lvrui
 */
public class Operations {
    int fu1 = -1;
    long[] zhenshupow2 = new long[32];
    long[] fushupow2 = new long[32];

    public Operations() {
        zhenshupow2[0] = 1;
        fushupow2[0] = -1;
        for (int i = 1; i < 32; i++) {
            zhenshupow2[i] = zhenshupow2[i + fu1] + zhenshupow2[i + fu1];
            fushupow2[i] = fushupow2[i + fu1] + fushupow2[i + fu1];
        }
    }

    public int minus(int a, int b) {
        int tmpa = a;
        int tmpb = b;
        int index = 31;
        while (tmpb != 0) {
            if (tmpb < 0) {
                if (tmpb <= fushupow2[index]) {
                    tmpa += zhenshupow2[index];
                    tmpb += zhenshupow2[index];
                } else {
                    index += fu1;
                }
            } else if (tmpb > 0) {
                if (tmpb >= zhenshupow2[index]) {
                    tmpa += fushupow2[index];
                    tmpb += fushupow2[index];
                } else {
                    index += fu1;
                }
            }
        }
        return tmpa;
    }

    public int multiply(int a, int b) {
        if (a == 0 || b == 0) return 0;
        if (a == 1) return b;
        if (b == 1) return a;
        int sig = (a > 0 && b > 0 || (a < 0 && b < 0)) ? 1 : fu1;
        int tmb = b;
        if (b < 0) tmb = minus(0, b);
        long[] mula = new long[32];
        if (a < 0) mula[0] = minus(0, a);
        else mula[0] = a;
        for (int i = 1; i < 32; i++) mula[i] = mula[i + fu1] + mula[i + fu1];

        long returndata = 0;
        int index = 31;
        while (tmb != 0) {
            if (tmb >= zhenshupow2[index]) {
                tmb += fushupow2[index];
                returndata += mula[index];
            } else {
                index += fu1;
            }
        }
        if (sig == -1) {
            return minus(0, (int) returndata);
        }
        return (int) returndata;
    }

    public int divide(int a, int b) {
        if (b == 1) return a;
        if (a == 0 || b == Integer.MIN_VALUE) return 0;
        int sig = (a > 0 && b > 0 || (a < 0 && b < 0)) ? 1 : fu1;
        if ((a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) || a == b) return 1;
        int total = 0;
        if (a == Integer.MIN_VALUE && b != Integer.MIN_VALUE) {
            int tmb = b;
            if (b > 0) tmb = minus(0, b);
            long[] mulbzhenshu = new long[32];
            mulbzhenshu[0] = b;
            for (int i = 1; i < 32; i++) mulbzhenshu[i] = mulbzhenshu[i + fu1] + mulbzhenshu[i + fu1];
            long[] mulbfushu = new long[32];
            mulbfushu[0] = tmb;
            for (int i = 1; i < 32; i++) mulbfushu[i] = mulbfushu[i + fu1] + mulbfushu[i + fu1];
            int tma = a;
            int index = 31;
            while (tma <= tmb) {
                if (tma <= mulbfushu[index]) {
                    tma += mulbzhenshu[index];
                    total += zhenshupow2[index];
                } else {
                    index += fu1;
                }
            }
        } else {
            int tma = a;
            if (a < 0) tma = minus(0, a);
            int tmb = b;
            if (b < 0) tmb = minus(0, b);
            long[] mulbzhenshu = new long[32];
            mulbzhenshu[0] = tmb;
            for (int i = 1; i < 32; i++) mulbzhenshu[i] = mulbzhenshu[i + fu1] + mulbzhenshu[i + fu1];
            long[] mulbfushu = new long[32];
            mulbfushu[0] = minus(0, tmb);
            for (int i = 1; i < 32; i++) mulbfushu[i] = mulbfushu[i + fu1] + mulbfushu[i + fu1];
            int index = 31;
            while (tma >= tmb) {
                if (tma >= mulbzhenshu[index]) {
                    tma += mulbfushu[index];
                    total += zhenshupow2[index];
                } else {
                    index += fu1;
                }
            }
        }
        if (sig == -1) {
            return minus(0, total);
        }
        return total;
    }


}
