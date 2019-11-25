package com.pmb.code2.test;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * * 两个数组都已经排好序了
 * * 要从后往前排序
 * * 如果从前往后排序，数组元素会被覆盖
 * <p>
 * 臨時數組
 */
public class Merge {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int num1 = m - 1;
        int num2 = n - 1;
        while (index >=0) {
            if (num1 >= 0 && num2 >= 0) {
                if (nums1[num1] > nums2[num2]) {
                    nums1[index--] = nums1[num1--];
                } else {
                    nums1[index--] = nums2[num2--];
                }
            } else if (num1 >= 0) {
                nums1[index--] = nums1[num1--];
            }else if (num2 >= 0) {
                nums1[index--] = nums2[num2--];
            }

        }
    }

    public static void main(String[] args) {
        Merge.merge(new int[]{0}, 0, new int[]{1}, 1);
    }

}
