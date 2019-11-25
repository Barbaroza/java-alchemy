package com.pmb.code.datastructure.sort;


import java.util.Arrays;

/**
 * @author lvrui
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (sb.length() == 0 && nums[i] == 0 && i + 1 < nums.length && nums[i] == nums[i + 1]) {
                continue;
            }
            sb.append(String.valueOf(nums[i]));
        }

        return sb.toString();
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] temp = Arrays.copyOfRange(nums, l, r + 1);
        int left = l;
        int m = mid + 1;
        for (int i = l; i <= r; i++) {
            if (left > mid) {
                nums[i] = temp[m - l];
                m++;
            } else if (m > r) {
                nums[i] = temp[left - l];
                left++;
            } else if (compare(temp[left - l], temp[m - l])) {
                nums[i] = temp[left - l];
                left++;
            } else {
                nums[i] = temp[m - l];
                m++;
            }
        }
    }

    private boolean compare(int num, int num1) {

        String leftValue = String.valueOf(num);
        String rightValue = String.valueOf(num1);
        if (Long.valueOf(leftValue + rightValue) > Long.valueOf(rightValue + leftValue)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        int[] a = new int[]{0, 0, 0};
        String ss = largestNumber.largestNumber(a);
        a = null;
    }
}
