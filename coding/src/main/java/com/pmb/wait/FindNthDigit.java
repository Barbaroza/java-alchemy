package com.pmb.wait;

/**
 * 400. 第N个数字
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * <p>
 * 注意:
 * n 是正数且在32位整数范围内 ( n < 231)。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 3
 * <p>
 * 输出:
 * 3
 * 示例 2:
 * <p>
 * 输入:
 * 11
 * <p>
 * 输出:
 * 0
 * <p>
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 * @star
 * @author lvrui
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        // 9*1 90*2 900*3 9000*4

        int init = 9;
        //考虑边界和索引问题
        int bit = 0;
        int offset = 0;
        long index = 0;
        while (n > index) {
            bit++;
            offset++;
            n -= index;
            index = init * bit * (long) Math.pow(10, offset - 1);
        }
        int num = (int) Math.ceil((double) n / bit);
        int currentIndex = n % bit;
        long current = (long) Math.pow(10, offset - 1) + num - 1;
        int count = bit - currentIndex;
        while (0 < count && count < bit) {
            current = current / 10;
            count--;
        }
        return (int) current % 10;
    }

    public static void main(String[] args) {
        FindNthDigit digit = new FindNthDigit();
        final int nthDigit = digit.findNthDigit(100);
    }


}
