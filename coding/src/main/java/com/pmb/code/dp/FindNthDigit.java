package com.pmb.code.dp;

/**
 * https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/submissions/
 *
 * @author lvrui
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        int i = 0;
        int ans = 0;
        int start = 0;
        while (i < n) {
            int t = start;
            int step = step(t);
            i += step;
            if (i >= n) {
                ans = ans(i - n, start);
            }

            start++;

        }

        return ans;
    }

    private int step(int start) {
        int cnt = 0;
        while (start != 0) {
            start /= 10;
            cnt++;
        }

        return cnt;

    }

    private int ans(int cnt, int num) {
        while (cnt > 0) {
            num /= 10;
            cnt--;
        }

        return num % 10;
    }

    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        findNthDigit.findNthDigit(10);
    }
}
