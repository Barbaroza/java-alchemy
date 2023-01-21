package com.pmb.code.datastructure.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * <p>
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 示例 2:
 * <p>
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 示例 3:
 * <p>
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 *
 * @author lvrui
 */
public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        return fractionToDecimal((long) numerator, (long) denominator);
    }

    public String fractionToDecimal(long numerator, long denominator) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        if (numerator < 0) {
            flag = !flag;
            numerator *= -1;
        }
        if (denominator < 0) {
            flag = !flag;
            numerator *= -1;
        }
        if (!flag && 0 != numerator) {
            stringBuilder.append("-");
        }
        long integer = numerator / denominator;
        stringBuilder.append(integer);
        if (0 == numerator % denominator) {
            return stringBuilder.toString();
        }
        stringBuilder.append(".");
        StringBuilder decimal = new StringBuilder();
        numerator -= integer * denominator;
        HashMap<Long, Long> hashMap = new HashMap<>();    //键代表的是被除数，值代表的是余数
        HashSet<Long> hashSet = new HashSet<>(); //存储重复的被除数
        StringBuilder loop = new StringBuilder();
        while (0 != numerator) {
            decimal.append(numerator * 10 / denominator);
            hashMap.put(numerator, numerator * 10 % denominator);
            numerator = hashMap.get(numerator);
            if (hashMap.containsKey(numerator)) {
                if (hashSet.contains(numerator)) {
                    break;
                } else {
                    loop.append(numerator * 10 / denominator);
                    hashSet.add(numerator);
                }

            }
        }
        if (0 != numerator) {
            return stringBuilder.toString() + decimal.substring(0, decimal.indexOf(loop.toString())) + "(" + loop + ")";
        } else {
            return stringBuilder.append(decimal).toString();
        }
    }

    private String fractionToDecimal2(long numerator, long denominator) {
        StringBuilder stringBuilder = new StringBuilder();

        boolean flag = true;
        if (numerator < 0) {
            flag = !flag;
            numerator *= -1;
        }
        if (denominator < 0) {
            flag = !flag;
            denominator *= -1;
        }
        if (!flag && numerator != 0) {
            stringBuilder.append("-");
        }
        long res = numerator / denominator;
        stringBuilder.append(res);
        if (numerator % denominator == 0) {
            return stringBuilder.toString();
        }
        stringBuilder.append(".");
        Set<Long> unique = new HashSet<Long>();
        Map<Long, Long> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder tail = new StringBuilder();
        numerator -= res * denominator;
        while (numerator != 0) {
            res = numerator * 10 / denominator;
            long value = numerator * 10 % denominator;
            sb.append(res);
            map.put(numerator, value);
            numerator = value;
            if (map.containsKey(numerator)) {
                if (!unique.add(numerator)) {
                    break;
                } else {
                    tail.append(value*10/denominator);
                }
            }
        }
        if (0 != numerator) {
            return stringBuilder.toString() + sb.substring(0, sb.indexOf(tail.toString())) + "(" + tail + ")";
        } else {
            return stringBuilder.append(sb).toString();
        }
    }

    public static void main(String[] args) {
        FractionToDecimal fractionToDecimal = new FractionToDecimal();
        String a = fractionToDecimal.fractionToDecimal2(1, 333);
        a = null;
    }
}
