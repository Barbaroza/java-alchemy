package com.pmb.code.datastructure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvrui
 */
public class ArrayTest {


    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 0, 0, 0, 0};
//        System.arraycopy(arr1, 3, arr1, 4, arr1.length - 3);
        arr1 =  null;

        List<String> arrStr = new ArrayList<>();
        arrStr.add("1");
        arrStr.add("2");
        arrStr.add("3");
        arrStr.add("4");
        arrStr.add(6, "5");
    }
}
