package com.pmb.code.datastructure.sort;

/**
 * @author lvrui
 */
public class InsertSort {


    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int v = array[i];
            while (j >= 0 && array[j] > v) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = v;
        }
    }


    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();

        int[] arr = new int[]{1, 3, 54, 1, 2, 3, 5, 67};
        insertSort.insertionSort(arr);
        arr = null;
    }
}
