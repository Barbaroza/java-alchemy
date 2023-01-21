package com.pmb.wait_2022_12_02;

/**
 * https://leetcode.cn/contest/biweekly-contest-93/problems/maximum-value-of-a-string-in-an-array/
 * @author lvrui
 */
public class MaximumValue {
    public int maximumValue(String[] strs) {
        int max = Integer.MIN_VALUE;
        for (String sub : strs) {
            Integer le = max;
            try {
                le = Integer.valueOf(sub);
            } catch (Exception e) {
                le = sub.length();
            }
            max = Math.max(le, max);
        }


        return max;
    }


    public static void main(String[] args) {
        Integer integer = Integer.valueOf("0010");
    }

}


