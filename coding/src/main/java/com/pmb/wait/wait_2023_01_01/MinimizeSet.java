package com.pmb.wait.wait_2023_01_01;

/**
 * https://leetcode.cn/contest/biweekly-contest-94/problems/minimize-the-maximum-of-two-arrays/
 *
 * @author lvrui
 */
public class MinimizeSet {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int num = 1;

        boolean oneBigger = divisor1 > divisor2;

        while (uniqueCnt1 != 0 || uniqueCnt2 != 0) {
            if (num % divisor1 == 0 && num % divisor2 != 0) {
                if (uniqueCnt2 > 0) {
                    uniqueCnt2--;
                }
            } else if (num % divisor1 != 0 && num % divisor2 == 0) {
                if (uniqueCnt1 > 0) {
                    uniqueCnt1--;
                }
            } else if (num % divisor1 != 0 && num % divisor2 != 0) {
                if (oneBigger) {
                    if (uniqueCnt2 > 0) {
                        uniqueCnt2--;

                    } else {
                        uniqueCnt1--;
                    }
                } else {
                    if (uniqueCnt1 > 0) {
                        uniqueCnt1--;

                    } else {
                        uniqueCnt2--;
                    }
                }
            }


            num++;
        }

        return num - 1;

    }

    public static void main(String[] args) {
        MinimizeSet minimizeSet = new MinimizeSet();
        minimizeSet.minimizeSet(2, 7, 1, 3);
    }


    // 就是最大公约数

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    boolean check(long d1, long d2, long m, long s1, long s2) {

        long t = gcd(d1, d2);
        long v = d1 / t * d2;

        // *) 谁都可以去
        long c3 = m - m / d1 - m / d2 + m / v;

        long c1 = m / d1 - m / v;
        long c2 = m / d2 - m / v;



        s2 = Math.max(s2 - c1, 0);
        s1 = Math.max(0, s1 - c2);

        return c3 >= s1 + s2;


        // return left >= s;

    }

    public int minimizeSet2(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {

        long s = uniqueCnt1 + uniqueCnt2;


        long l = uniqueCnt1 + uniqueCnt2;
        long r = 10 * l;

        // *)
        long ans = 0;
        while (l <= r) {

            long m = l + (r - l) / 2;

            if (check(divisor1, divisor2, m, uniqueCnt1, uniqueCnt2)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }

        }

        return (int)ans;


    }
}
