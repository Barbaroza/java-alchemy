package com.pmb.wait.wait_2022_06;

/**
 * https://leetcode.cn/problems/duplicate-zeros/
 * <p>
 * 1089. 复写零
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 *
 * @author lvrui
 */
public class DuplicateZeros {

    int zero = 0;

    public void duplicateZeros(int[] arr) {
        int[] res = new int[arr.length];
        int id = 0;
        int io = 0;
        while (id < arr.length) {
            int current = arr[io++];
            res[id++] = current;
            if (current == zero&&id<arr.length) {
                res[id++] = zero;
            }
        }

        System.arraycopy(res, 0, arr, 0, arr.length);
    }

}
