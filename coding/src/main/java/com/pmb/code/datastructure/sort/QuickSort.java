package com.pmb.code.datastructure.sort;

/**
 * @author lvrui
 */
public class QuickSort {
    public void sort(Comparable[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private int partition(Comparable[] arr, int l, int r) {
        int left = l;
        int right = r;
        Comparable v = arr[l];
        while (left < right) {
            while (left < right && arr[right].compareTo(v) <= 0) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left].compareTo(v) >= 0) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[right] = v;
        return right;
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        Integer[] arr = new Integer[]{2, 21, 4, 2, 1, 76, 1, 21, 23, 5};
        quickSort.sort(arr, 0, arr.length - 1);
        arr = null;
    }
}
