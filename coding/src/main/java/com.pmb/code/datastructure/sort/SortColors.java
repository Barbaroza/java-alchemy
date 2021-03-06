package com.pmb.code.datastructure.sort;

/**
 * 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * @author lvrui
 */
public class SortColors {
    public static void sortColors(int[] nums) {

        int[] temp = new int[3];
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            if (currentValue == 0) {
                temp[0]++;
            } else if (currentValue == 1) {
                temp[1]++;
            } else {
                temp[2]++;
            }
        }
        int a = 0;
        for (int index = 0; index < temp.length; index++) {
            int size = temp[index];
            for (int i = 0; i < size; i++) {
                nums[a] = index;
                a++;
            }
        }

    }

    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }
}
