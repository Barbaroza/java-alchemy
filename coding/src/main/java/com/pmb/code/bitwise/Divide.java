package com.pmb.code.bitwise;

/**
 * @author lvrui
 */
public class Divide {

    public int divide(int a, int b) {
        boolean sign = false;
        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            }
            if (b == -1) {
                return Integer.MAX_VALUE;
            }

            sign = true;
        }
        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }
        if (a == 0) {
            return 0;
        }
        if (sign) {
            a += 1;
        }
        int isN = (a ^ b) >= 0 ? 1 : -1;
        int ans = 0;

        int absA = a;
        int absB = b;
        absA = Math.abs(a);
        absB = Math.abs(b);


        while (absA >= absB) {
            int c = 1;
            int d = absB;

            while (d < Integer.MAX_VALUE >> 1 && d + d <= absA) {
                d += d;
                c += c;
            }

            absA -= d;
            if (sign) {
                absA += 1;
                sign = false;
            }
            ans += c;

        }

        return ans * isN;
    }


    public static void main(String[] args) {
        Divide divide = new Divide();
        divide.divide(10, 3);
    }

}
