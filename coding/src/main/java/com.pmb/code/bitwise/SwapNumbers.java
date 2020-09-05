package com.pmb.code.bitwise;

/**
 * https://leetcode-cn.com/problems/swap-numbers-lcci/
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 * <p>
 * 示例：
 * <p>
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 * 提示：
 * <p>
 * numbers.length == 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-numbers-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lvrui
 */
public class SwapNumbers {

    public int[] swapNumbers(int[] numbers) {
        if (numbers != null && numbers.length > 1) {
            //      01 = 00^01
            numbers[0] = numbers[0] ^ numbers[1];
            //      00 = 01^01
            numbers[1] = numbers[0] ^ numbers[1];
            //      01 = 01^00
            numbers[0] = numbers[0] ^ numbers[1];
        }
        return numbers;
    }

    public int[] swapNumbers2(int[] numbers) {
        if (numbers != null && numbers.length > 1) {
            //     3   = 1 + 2
            numbers[0] = numbers[0] + numbers[1];
            //     1   = 3 - 2
            numbers[1] = numbers[0] - numbers[1];
            //     2   = 3 - 1
            numbers[0] = numbers[0] - numbers[1];
        }
        return numbers;
    }
}
