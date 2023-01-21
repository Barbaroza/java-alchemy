package com.pmb.code.datastructure.array;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author lvrui
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int bePlus = 1;
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int[] res = new int[digits.length + 1];

        for (int i = digits.length - 1; i >= 0; i--) {
            int current = digits[i] + bePlus;
            res[i + 1] = (current) % 10;
            bePlus = current / 10;
        }

        if (bePlus == 0) {
            res = Arrays.copyOfRange(res, 1, res.length);
        } else {
            res[0] = bePlus;
        }
        return res;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        plusOne.plusOne(new int[]{1, 2, 3});
    }
}
