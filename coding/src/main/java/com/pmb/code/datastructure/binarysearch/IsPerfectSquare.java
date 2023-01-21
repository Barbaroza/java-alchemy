package com.pmb.code.datastructure.binarysearch;

/**
 * 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 *
 * @author lvrui
 */
public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        long end = num >> 1;
        long start = 1;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        isPerfectSquare.isPerfectSquare(808201);
    }
}
