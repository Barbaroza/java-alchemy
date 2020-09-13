package com.pmb.code.greedy;

import java.util.LinkedList;
import java.util.List;

/**
 * 1414. 和为 K 的最少斐波那契数字数目
 * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 * <p>
 * 斐波那契数字定义为：
 * <p>
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
 * 数据保证对于给定的 k ，一定能找到可行解。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 7
 * 输出：2
 * 解释：斐波那契数字为：1，1，2，3，5，8，13，……
 * 对于 k = 7 ，我们可以得到 2 + 5 = 7 。
 * 示例 2：
 * <p>
 * 输入：k = 10
 * 输出：2
 * 解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
 * 示例 3：
 * <p>
 * 输入：k = 19
 * 输出：3
 * 解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 10^9
 * 通过次数4,690提交次数8,235
 *
 * @author lvrui
 */
public class FindMinFibonacciNumbers {

    public int findMinFibonacciNumbers(int k) {
        int first = 1;
        int second = 1;
        int current = 0;
        List<Integer> arr = new LinkedList<>();
        arr.add(1);
        arr.add(1);
        while (true) {
            current = first + second;
            if (current > k) {
                break;
            }
            arr.add(current);
            first = second;
            second = current;
        }
        return getN(k, arr, arr.size() - 1);
    }

    private int getN(int k, List<Integer> arr, int i) {
        Integer integer = arr.get(i);
        int remainder = k % integer;
        int value = k / integer;
        return remainder == 0 ? value : value + getN(remainder, arr, i - 1);
    }

    public int getFibonacci(int k) {
        if (k == 1 || k == 0) {
            return 1;
        } else if (k == 2) {
            return 2;
        }
        int temp = 0;
        int l = 1;
        int res = 2;
        int i = 0;
        while (i <= k) {
            temp = res;
            res = res + l;
            l = temp;
            if (res == k) {
                return k;
            } else if (res > k) {
                return temp;
            }
            i++;
        }
        return 0;
    }

    public int findMinFibonacciNumbers2(int k) {
        int less = getFibonacci(k);
        if (less == k) {
            return 1;
        }
        return findMinFibonacciNumbers(k - less) + 1;

    }


    public static void main(String[] args) {
        FindMinFibonacciNumbers findMaxConsecutiveOnes = new FindMinFibonacciNumbers();
        int asdasd = findMaxConsecutiveOnes.findMinFibonacciNumbers2(19);


    }
}
