package com.pmb.code.model;

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
        int current = second;
        List<Integer> arr = new LinkedList<>();
        arr.add(1);
        while (current < k) {
            arr.add(current);
            int temp = current;
            current = first + second;
            first = second;
            second = temp;
        }
        return getN(k, arr, arr.size() - 1);
    }

    private int getN(int k, List<Integer> arr, int i) {
        Integer integer = arr.get(i);
        int divide = k % integer;
        int res = k / integer;
        return divide == 0 ? res : res + getN(divide, arr, i - 1);
    }

    public static void main(String[] args) {
        FindMinFibonacciNumbers findMaxConsecutiveOnes = new FindMinFibonacciNumbers();
        int asdasd = findMaxConsecutiveOnes.findMinFibonacciNumbers(19);
    }
}
