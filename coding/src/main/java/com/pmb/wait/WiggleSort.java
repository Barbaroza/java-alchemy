package com.pmb.wait;

import java.util.Arrays;

/**
 * 面试题 10.11. 峰与谷
 * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
 * <p>
 * 示例:
 * <p>
 * 输入: [5, 3, 1, 2, 3]
 * 输出: [5, 1, 3, 2, 3]
 * 提示：
 * <p>
 * nums.length <= 10000
 *
 * @author lvrui
 */
public class WiggleSort {

    public void wiggleSort(int[] nums) {
        for (int index = 1; index < nums.length - 1; index++) {
            if (nums[index - 1] < nums[index]) {
                int temp = nums[index];
                nums[index] = nums[index - 1];
                nums[index - 1] = temp;
            }
            if (nums[index] > nums[index + 1]) {
                int temp = nums[index];
                nums[index] = nums[index + 1];
                nums[index + 1] = temp;
            }
        }
    }


    public void wiggleSort2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 0 && nums[i] < nums[i - 1]) || (i % 2 != 0 && nums[i] > nums[i - 1])) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }

    public void wiggleSort3(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int l = nums.length;
        if (nums.length == 2) {
            int a = nums[0];
            int b = nums[1];
            nums[0] = Math.max(a, b);
            nums[1] = Math.min(a, b);
            return;
        }

        Arrays.sort(nums);
        int left = 0;
        while (left < l - 1) {
            int t = nums[left + 1];
            nums[left + 1] = nums[left];
            nums[left] = t;
            left += 2;
        }
    }
    public static void main(String[] args) {
        WiggleSort sort = new WiggleSort();
        int[] test = new int[]{5, 3, 1, 2, 3};
        int[] ints = Arrays.copyOf(test, test.length);
        sort.wiggleSort3(test);

        ints = null;
    }

}
