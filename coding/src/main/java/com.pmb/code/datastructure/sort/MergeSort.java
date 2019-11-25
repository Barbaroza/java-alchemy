package com.pmb.code.datastructure.sort;

import java.util.Arrays;

/**
 * @author lvrui
 */
public class MergeSort {
    public void sort(Comparable[] arr, int l, int r) {
        if (r <= l) {
            return;
        }
        int mid = (r + l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private void merge(Comparable[] arr, int l, int m, int r) {
        int left = l;
        int mid = m + 1;
        Comparable[] temp = Arrays.copyOfRange(arr, l, r + 1);
        for (int i = l; i <= r; i++) {
            if (left > m) {
                arr[i] = temp[mid - l];
                mid++;
            } else if (mid > r) {
                arr[i] = temp[left - l];
                left++;
            } else if (temp[left - l].compareTo(temp[mid - l]) < 0) {
                arr[i] = temp[left - l];
                left++;
            } else {
                arr[i] = temp[mid - l];
                mid++;
            }
        }
    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        Integer[] arr = new Integer[]{21, 123, 3, 31, 45, 1, 31, 46, 7};
        mergeSort.sort(arr, 0, arr.length - 1);
        arr = null;
    }
}
