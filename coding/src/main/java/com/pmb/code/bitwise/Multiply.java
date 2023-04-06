package com.pmb.code.bitwise;

/**
 * @author lvrui
 */
public class Multiply {
    public int multiply(int A, int B) {
        int ans = 0;
        if (A == 0 || B == 0) {
            return ans;
        }
        int b = Math.min(A, B);
        int a = b == A ? B : A;
        int bas = 0;
        while (b > 1) {
            if ((b & 1) == 1) {
                bas += a;
            }
            a <<= 1;

            b >>= 1;
        }

        return a + bas;
    }

    public int multiply3(int A, int B) {
        if (A > B) {
            return mul(A, B);
        } else {
            return mul(B, A);
        }
    }

    public static int mul(int n, int m) {
        int bas = n;
        int res = 0;
        while (m != 0) {
            if (m % 2 == 1) {
                res += bas;
            }
            bas = bas + bas;
            m = m / 2;
        }
        return res;
    }

    public int multiply2(int A, int B) {
        return B != 0 ? multiply(A << 1, B >> 1) + ((B & 1) == 1 ? A : 0) : 0;
    }

    public static void main(String[] args) {
        Multiply m = new Multiply();
        m.multiply(15, 14);
    }

    public int multiply4(int A, int B) {
        if (A > B) {
            return mul4(A, B);
        } else {
            return mul4(B, A);
        }
    }

    public static int mul4(int n, int m) {
        int bas = n;
        int res = 0;
        while (m != 0) {
            if (m % 2 == 1) {
                res += bas;
            }
            bas = bas + bas;
            m = m / 2;
        }
        return res;
    }
    public int multiply5(int A, int B) {
        int ans = 0;
        int a = Math.max(A,B);
        int bas = a;
        int b = a == A ? B : A;

        while(b!=0){
            if((b & 1) == 1){
                ans += bas;
            }
            bas <<=1;
            b>>=1;
        }

        return ans;
    }

}
