package com.pmb.algorithm.sorting.basic.bubble;

import java.util.Arrays;

public class Main {

    // 比较SelectionSort, InsertionSort和BubbleSort三种排序算法的性能效率
    public static void main(String[] args) {

        int N = 20000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("SelectionSort", arr1);
        SortTestHelper.testSort("InsertionSort", arr2);
        SortTestHelper.testSort("BubbleSort", arr3);

        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("SelectionSort", arr1);
        SortTestHelper.testSort("InsertionSort", arr2);
        SortTestHelper.testSort("BubbleSort", arr3);

        return;
    }
}
