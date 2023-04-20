package com.pmb.code.multipointers;

/**
 * https://leetcode.cn/problems/sub-sort-lcci/solution/yi-bian-bian-li-shuang-zhi-zhen-by-chen-wei-zhe/
 *
 * @author lvrui
 */
public class SubSort {
    public int[] subSort(int[] array) {
        if (array == null || array.length == 0) return new int[]{-1, -1};
        int last = -1, first = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] < max) {
                last = i;
            } else {
                max = Math.max(max, array[i]);
            }

            if (array[len - 1 - i] > min) {
                first = len - 1 - i;
            } else {
                min = Math.min(min, array[len - 1 - i]);
            }
        }
        return new int[]{first, last};
    }
    public int[] subSort2(int[] array) {
        int[] ans = new int[]{-1,-1};

        int l  = 0;
        int r = array.length-1;

        Integer MAX = Integer.MIN_VALUE;
        Integer MIN = Integer.MAX_VALUE;
        while(l<array.length){
            if(array[l]>=MAX){
                MAX = array[l];
            }else{
                ans[1] = l;
            }
            l++;
        }

        while(r>=0){
            if(array[r]<=MIN){
                MIN = array[r];
            }else{
                ans[0] =r;
            }
            r--;
        }

        return ans;
    }

}
