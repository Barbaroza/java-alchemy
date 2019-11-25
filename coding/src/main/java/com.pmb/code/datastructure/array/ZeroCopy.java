package com.pmb.code.datastructure.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author lvrui
 */

public class ZeroCopy {
    public void moveZeroes1(int[] nums) {
        if (nums == null) {
            return;
        }
        int insertIndex = nums.length - 1;
        for (int i = 0; i <= insertIndex; i++) {
            if (nums[i] == 0) {
                int toInsertValue = nums[i];
                int moveIndex = i;
                while (moveIndex + 1 <= insertIndex) {
                    nums[moveIndex] = nums[moveIndex + 1];
                    moveIndex++;
                }
                nums[insertIndex] = toInsertValue;
                insertIndex--;
                i--;
            }
        }
    }

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[temp] = nums[i];
                temp++;
            }
        }
        while (temp < nums.length) {
            nums[temp++] = 0;
        }
    }

    public static void main(String[] args) {
        ZeroCopy zeroCopy = new ZeroCopy();
        int[] test = new int[]{0, 0, 1};
        zeroCopy.moveZeroes(test);
        test = null;
    }
}
