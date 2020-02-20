package com.pmb.code.datastructure.array;

/**
 * https://www.cnblogs.com/grandyang/p/4298711.html
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 *
 * @author lvrui
 * @star
 */
public class Rotate {


    public void rotate(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length == 0) {
            return;
        }
        int tempK = k;
        if (tempK > nums.length) {
            tempK = tempK % nums.length;
        }
        int[] destArray = new int[nums.length];
        System.arraycopy(nums, tempK + 1, destArray, 0, nums.length - tempK - 1);
        System.arraycopy(nums, 0, destArray, nums.length - tempK - 1, tempK + 1);
        System.arraycopy(destArray, 0, nums, 0, nums.length);
        nums = null;
    }


    public void rotatee(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length <= 1) {
            return;
        }

        int start = 0;
        int next = 0;
        int preValue = nums[start];
        int temp = nums[next];
        for (int i = 0; i < nums.length; i++) {
            next = (k + next) % nums.length;
            temp = nums[next];
            nums[next] = preValue;
            preValue = temp;
            if (next == start) {
                start++;
                next++;
                if (start < nums.length) {
                    preValue = nums[start];
                }
            }

        }

        nums = null;
    }

    public void rotateeee(int[] nums, int k) {
        if (nums == null || k < 0 || nums.length < 2) {
            return;
        }
        int start = 0;
        int end = 0;
        int preValue = nums[start];
        int nextValue = nums[start];
        for (int i = 0; i < nums.length; i++) {
            end = (k + end) % nums.length;
            nextValue = nums[end];
            nums[end] = preValue;
            preValue = nextValue;
            if (start == end) {
                start++;
                end++;
                if (start < nums.length) {
                    preValue = nums[start];
                }
            }

        }
    }

    public void rotateee(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length == 0) {
            return;
        }
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
        nums = null;
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Rotate a = new Rotate();
        a.rotatee(new int[]{1, 2}, 1);
        a.rotate(new int[]{1, 2}, 1);
    }
}
